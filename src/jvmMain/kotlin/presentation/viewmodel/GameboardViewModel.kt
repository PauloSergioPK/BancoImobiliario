package presentation.viewmodel

import domain.usecase.AddPlayersInGameboardUseCase
import domain.usecase.GetInitialGameboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GameboardViewModel(
    private val getInitialGameboardUseCase: GetInitialGameboardUseCase,
    private val addPlayersInGameboardUseCase: AddPlayersInGameboardUseCase
) {

    val state: MutableStateFlow<GameboardContract.State> = MutableStateFlow(GameboardContract.State())

    fun processEvent(event: GameboardContract.Events) {
        when (event) {
            is GameboardContract.Events.InitializeGameboard -> {
                state.update {
                    GameboardContract.State(
                        gameboard = getInitialGameboardUseCase.execute(),
                        isPlayersQuantityLayoutVisible = true
                    )
                }
            }

            is GameboardContract.Events.OnPlayersQuantityInputChange -> {
                val input = event.input.take(1)
                val numberInput = input.toIntOrNull()
                val validInput = numberInput in 1..8
                val validatedInput = if (numberInput != null) input else ""
                state.update {
                    it.copy(
                        playersQuantityInput = validatedInput,
                        isConfirmPlayersButtonVisible = validInput,
                        isPlayersQuantityErrorVisible = validatedInput.isNotEmpty() && !validInput
                    )
                }
            }

            is GameboardContract.Events.ConfirmPlayersQuantity -> {
                state.update {
                    it.copy(
                        gameboard = addPlayersInGameboardUseCase.execute(it.gameboard, it.playersQuantityInput),
                        isPlayersQuantityLayoutVisible = false
                    )
                }
            }
        }
    }
}