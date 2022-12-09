package domain.usecase

import domain.model.gameboard.Gameboard

interface GetInitialGameboardUseCase {
    fun execute(): Gameboard
}