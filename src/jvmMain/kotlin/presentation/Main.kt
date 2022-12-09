package presentation

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import data.repository.GameboardRepositoryImpl
import domain.repository.GameboardRepository
import domain.usecase.GetInitialGameboardUseCase
import domain.usecase.GetInitialGameboardUseCaseImpl
import presentation.ui.screens.CardboardScreen
import presentation.ui.theme.AppTheme
import presentation.viewmodel.GameboardContract
import presentation.viewmodel.GameboardViewModel

const val APP_NAME = "Banco Imobiliário"

private val repository: GameboardRepository = GameboardRepositoryImpl()
private val getInitialGameboardUseCase: GetInitialGameboardUseCase = GetInitialGameboardUseCaseImpl(repository)
private val gameboardViewModel = GameboardViewModel(getInitialGameboardUseCase)

fun main() = application {
    gameboardViewModel.processEvent(GameboardContract.Events.InitializeGameboard)

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
            CardboardScreen(gameboardViewModel)
        }
    }
}
