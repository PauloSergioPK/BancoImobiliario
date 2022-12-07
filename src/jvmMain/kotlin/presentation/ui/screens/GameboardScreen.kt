package presentation.ui.screens

import androidx.compose.runtime.Composable
import domain.model.colors.GameColor
import domain.model.gameboard.Gameboard
import domain.model.gameboard.GameboardHouse
import domain.model.gameboard.GameboardHouseKind
import domain.model.player.BankAccount
import domain.model.player.Player
import presentation.ui.components.GameboardTable

@Composable
fun CardboardScreen() {
    val fakeList = mutableListOf<GameboardHouse>()
    repeat(44) { index ->
        fakeList.add(
            GameboardHouse(
                id = "1",
                players = if (index == 0) {
                    listOf(
                        Player("nome", BankAccount(balance = 1000F), color = GameColor.GREEN)
                    )
                } else listOf(),
                kind = GameboardHouseKind.GoToJail
            )
        )
    }
    val gameboard = Gameboard(fakeList)
    GameboardTable(gameboard)
}

