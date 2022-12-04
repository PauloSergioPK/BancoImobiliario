package presentation

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.*
import presentation.ui.screens.CardboardScreen

const val APP_NAME = "Banco Imobiliário"

fun main() = application {
    val windowState = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        placement = WindowPlacement.Maximized,
    )
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = APP_NAME,
        icon = painterResource("images/app_icon.png")
    ) {
        CardboardScreen()
    }
}
