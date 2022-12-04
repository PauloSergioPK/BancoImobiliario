package presentation.ui.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import domain.model.colors.GameColor
import presentation.ui.theme.*

@Composable
fun Player(
    gameColor: GameColor,
    modifier: Modifier = Modifier
) {
    val color = when (gameColor) {
        GameColor.RED -> Red
        GameColor.GREEN -> Green
        GameColor.YELLOW -> Yellow
        GameColor.ORANGE -> Orange
        GameColor.DARK_BLUE -> DarkBlue
        GameColor.DARK_PURPLE -> DarkPurple
        GameColor.LIGHT_PURPLE -> LightPurple
        GameColor.LIGHT_BLUE -> LightBlue
    }
    Icon(
        painter = painterResource("images/ic_player.svg"),
        contentDescription = null,
        tint = color,
        modifier = modifier
    )
}