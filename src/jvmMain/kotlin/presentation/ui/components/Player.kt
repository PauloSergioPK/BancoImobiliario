package presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import domain.model.colors.GameColor
import presentation.ui.utils.getPlayerColorFromGameColor

@Composable
fun Player(
    gameColor: GameColor,
    modifier: Modifier = Modifier
) {
    val color = getPlayerColorFromGameColor(gameColor)
    Box(modifier = modifier) {
        Icon(
            painter = painterResource("images/ic_player.svg"),
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier.offset(y = 3.dp).alpha(0.5F)
        )
        Icon(
            painter = painterResource("images/ic_player.svg"),
            contentDescription = null,
            tint = color,
            modifier = modifier
        )
    }

}