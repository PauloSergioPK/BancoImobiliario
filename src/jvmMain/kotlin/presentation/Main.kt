package presentation

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import data.repository.GameboardRepositoryImpl
import domain.repository.GameboardRepository
import domain.usecase.AddPlayersInGameboardUseCase
import domain.usecase.AddPlayersInGameboardUseCaseImpl
import domain.usecase.GetInitialGameboardUseCase
import domain.usecase.GetInitialGameboardUseCaseImpl
import kotlinx.coroutines.*
import presentation.ui.screens.CardboardScreen
import presentation.ui.theme.AppTheme
import presentation.viewmodel.GameboardContract
import presentation.viewmodel.GameboardViewModel

const val APP_NAME = "Banco Imobiliário"

private val repository: GameboardRepository = GameboardRepositoryImpl()
private val getInitialGameboardUseCase: GetInitialGameboardUseCase = GetInitialGameboardUseCaseImpl(repository)
private val addPlayersInGameboardUseCase: AddPlayersInGameboardUseCase = AddPlayersInGameboardUseCaseImpl()

fun main() = application {
    val coroutineScope = rememberCoroutineScope()

    val viewModel = remember {
        GameboardViewModel(
            getInitialGameboardUseCase,
            addPlayersInGameboardUseCase,
            coroutineScope
        )
    }

    viewModel.processEvent(GameboardContract.Events.InitializeGameboard)

    val windowState = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(1400.dp, 1000.dp)
    )
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = APP_NAME,
        icon = painterResource("images/app_icon.png"),
    ) {
        AppTheme {
            CardboardScreen(viewModel)
        }
    }
}
