package presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import presentation.ui.components.GameboardTable
import presentation.viewmodel.GameboardViewModel

@Composable
fun CardboardScreen(
    viewModel: GameboardViewModel
) {
    val uiState = viewModel.state.collectAsState().value
    GameboardTable(uiState.gameboard)
}

