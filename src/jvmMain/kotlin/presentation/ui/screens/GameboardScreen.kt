package presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun CardboardScreen() {
    Image(
        painter = painterResource("images/gameboard_background.png"),
        contentDescription = null
    )
}