package domain.repository

import domain.model.gameboard.Gameboard

interface GameboardRepository {
    fun getInitialGameboard(): Gameboard
}