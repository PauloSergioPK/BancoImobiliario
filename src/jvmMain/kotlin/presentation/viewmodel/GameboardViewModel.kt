package presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import domain.usecase.AddPlayersInGameboardUseCase
import domain.usecase.GetInitialGameboardUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class GameboardViewModel(
    private val getInitialGameboardUseCase: GetInitialGameboardUseCase,
    private val addPlayersInGameboardUseCase: AddPlayersInGameboardUseCase
){

    val uiState: MutableStateFlow<GameboardContract.State> = MutableStateFlow(GameboardContract.State())
    val currentState get() = uiState.value

    val uiEffect: Channel<GameboardContract.Effects> = Channel { }

    fun processEvent(event: GameboardContract.Events) = runBlocking {
        when (event) {
            is GameboardContract.Events.InitializeGameboard -> {
                uiState.update {
                    GameboardContract.State(
                        gameboard = mutableStateOf(getInitialGameboardUseCase.execute()),
                        isPlayersQuantityLayoutVisible = true
                    )
                }
            }

            is GameboardContract.Events.OnPlayersQuantityInputChange -> {
                val input = event.input.take(1)
                val numberInput = input.toIntOrNull()
                val validInput = numberInput in 1..8
                val validatedInput = if (numberInput != null) input else ""
                uiState.update {
                    it.copy(
                        playersQuantityInput = validatedInput,
                        isConfirmPlayersButtonVisible = validInput,
                        isPlayersQuantityErrorVisible = validatedInput.isNotEmpty() && !validInput
                    )
                }
            }

            is GameboardContract.Events.ConfirmPlayersQuantity -> {
                val updatedGameboard = addPlayersInGameboardUseCase.execute(
                    currentState.gameboard.value,
                    currentState.playersQuantityInput
                )
                uiState.update {
                    it.copy(
                        gameboard = mutableStateOf(updatedGameboard),
                        isPlayersQuantityLayoutVisible = false
                    )
                }
                updatedGameboard.getCurrentTurnPlayer()?.let {
                    setEffect(GameboardContract.Effects.ShowTurnPlayerDialog(it))
                }
            }

            is GameboardContract.Events.AdvancePlayerInGameboard -> {
                val updatedGameboard = currentState.gameboard.value
                for (i in 0 until event.housesCount) {
                    updatedGameboard.advancePlayerInGameboard(event.player.id,1)
                    uiState.update { it.copy(gameboard = mutableStateOf(updatedGameboard)) }
                }
            }
        }
    }

    private suspend fun setEffect(effect: GameboardContract.Effects) {
        uiEffect.send(effect)
    }
}