package presentation.viewmodel

import domain.model.gameboard.Gameboard

object GameboardContract {

    sealed interface Events {
        object InitializeGameboard: Events
    }

    sealed interface Effects {

    }

    data class State(
        val gameboard: Gameboard = Gameboard(listOf())
    )
}