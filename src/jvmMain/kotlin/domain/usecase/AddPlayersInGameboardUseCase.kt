package domain.usecase

import domain.model.gameboard.Gameboard

interface AddPlayersInGameboardUseCase {
    fun execute(gameboard: Gameboard, quantityInput: String): Gameboard
}