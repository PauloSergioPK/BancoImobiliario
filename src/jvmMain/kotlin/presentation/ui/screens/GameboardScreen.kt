package presentation.ui.screens

import androidx.compose.runtime.Composable
import domain.model.colors.GameColor
import domain.model.gameboard.GameboardHouse
import domain.model.gameboard.GameboardHouseKind
import domain.model.player.BankAccount
import domain.model.player.Player
import presentation.ui.components.GameboardHouseCard

@Composable
fun CardboardScreen() {
    val gameboardHouse = GameboardHouse(
        id = "1",
        players = listOf(
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            ),
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            ),
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            ),
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            ),
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            ),
            Player(
                name = "joao",
                bankAccount = BankAccount(
                    balance = 1000F
                ),
                color = GameColor.RED
            )
        ),
        kind = GameboardHouseKind.GoToJail
    )
    GameboardHouseCard(gameboardHouse)
}