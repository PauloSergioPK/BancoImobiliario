package presentation.ui.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import domain.model.player.Player
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import presentation.ui.components.GameboardTable
import presentation.ui.components.PlayersQuantityDialog
import presentation.ui.components.TurnPlayerDialog
import presentation.viewmodel.GameboardContract
import presentation.viewmodel.GameboardViewModel


@Composable
fun CardboardScreen(viewModel: GameboardViewModel) {

    val uiState = viewModel.uiState.collectAsState().value
    val isPlayersQuantityLayoutVisible = uiState.isPlayersQuantityLayoutVisible
    val playersQuantityInput = uiState.playersQuantityInput
    val isPlayersQuantityErrorVisible = uiState.isPlayersQuantityErrorVisible
    val isConfirmPlayersButtonVisible = uiState.isConfirmPlayersButtonVisible
    var turnPlayer: Player? by rememberSaveable { mutableStateOf(null) }

    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        viewModel.uiEffect.consumeAsFlow().collectLatest {
            when (it) {
                is GameboardContract.Effects.ShowTurnPlayerDialog -> {
                    turnPlayer = it.player
                }
            }
        }
    }

    GameboardTable(uiState.gameboard)
    PlayersQuantityDialog(
        isPlayersQuantityLayoutVisible = isPlayersQuantityLayoutVisible,
        isPlayersQuantityErrorVisible = isPlayersQuantityErrorVisible,
        playersQuantityInput = playersQuantityInput,
        isConfirmPlayersButtonVisible = isConfirmPlayersButtonVisible,
        onValueChanged = { viewModel.processEvent(GameboardContract.Events.OnPlayersQuantityInputChange(it)) },
        onConfirmQuantityClicked = { viewModel.processEvent(GameboardContract.Events.ConfirmPlayersQuantity) }
    )

    turnPlayer?.let {
        TurnPlayerDialog(player = turnPlayer!!, onRollDicesClicked = { turnPlayer = null })
    }
}

