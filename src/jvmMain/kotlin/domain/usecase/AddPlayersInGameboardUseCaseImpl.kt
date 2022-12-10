package domain.usecase

import domain.model.colors.GameColor
import domain.model.gameboard.Gameboard
import domain.model.player.BankAccount
import domain.model.player.Player

class AddPlayersInGameboardUseCaseImpl: AddPlayersInGameboardUseCase {
    override fun execute(gameboard: Gameboard, quantityInput: String): Gameboard {
        val quantity = quantityInput.toIntOrNull() ?: 0
        val players = mutableListOf<Player>()
        for(i in 0 until  quantity) {
            players.add(
                Player(
                    bankAccount = BankAccount(200F),
                    color = GameColor.values()[i]
                )
            )
        }
        gameboard.addPlayersIntoStartHouse(players)
        return gameboard
    }
}