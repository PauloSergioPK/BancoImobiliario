package presentation.viewmodel

import domain.model.gameboard.Gameboard
import domain.model.player.Player

object GameboardContract {

    sealed interface Events {
        object InitializeGameboard: Events
        data class OnPlayersQuantityInputChange(val input: String): Events
        object ConfirmPlayersQuantity: Events
    }

    sealed interface Effects {
        data class ShowTurnPlayerDialog(
            val player: Player
        ): Effects
    }

    data class State(
        val gameboard: Gameboard = Gameboard(listOf()),
        val isPlayersQuantityLayoutVisible: Boolean = false,
        val playersQuantityInput: String = "",
        val isPlayersQuantityErrorVisible: Boolean = false,
        val isConfirmPlayersButtonVisible: Boolean = false
    )
}