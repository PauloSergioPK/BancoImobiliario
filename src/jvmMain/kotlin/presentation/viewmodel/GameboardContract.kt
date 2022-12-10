package presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import domain.model.gameboard.Gameboard
import domain.model.player.Player

object GameboardContract {

    sealed interface Events {
        object InitializeGameboard : Events
        data class OnPlayersQuantityInputChange(val input: String) : Events
        object ConfirmPlayersQuantity : Events

        data class AdvancePlayerInGameboard(
            val player: Player,
            val housesCount: Int
        ) : Events
    }

    sealed interface Effects {
        data class ShowTurnPlayerDialog(
            val player: Player
        ) : Effects
    }

    data class State(
        var gameboard: MutableState<Gameboard> = mutableStateOf(Gameboard(listOf())),
        val isPlayersQuantityLayoutVisible: Boolean = false,
        val playersQuantityInput: String = "",
        val isPlayersQuantityErrorVisible: Boolean = false,
        val isConfirmPlayersButtonVisible: Boolean = false
    )
}