package presentation.ui.utils

import androidx.compose.ui.graphics.Color
import domain.model.colors.GameColor
import presentation.ui.theme.*

fun getPlayerColorFromGameColor(gameColor: GameColor): Color {
    return when (gameColor) {
        GameColor.RED -> Red500
        GameColor.GREEN -> Green500
        GameColor.YELLOW -> Yellow500
        GameColor.ORANGE -> Orange500
        GameColor.DARK_BLUE -> DarkBlue500
        GameColor.DARK_PURPLE -> DarkPurple500
        GameColor.LIGHT_PURPLE -> LightPurple500
        GameColor.LIGHT_BLUE -> LightBlue500
    }
}

fun getGameboardHouseCardColorFromGameColor(gameColor: GameColor): Color {
    return when (gameColor) {
        GameColor.RED -> Red700
        GameColor.GREEN -> Green700
        GameColor.YELLOW -> Yellow700
        GameColor.ORANGE -> Orange700
        GameColor.DARK_BLUE -> DarkBlue700
        GameColor.DARK_PURPLE -> DarkPurple700
        GameColor.LIGHT_PURPLE -> LightPurple700
        GameColor.LIGHT_BLUE -> LightBlue700
    }
}