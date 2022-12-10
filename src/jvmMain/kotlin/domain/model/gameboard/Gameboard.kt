package domain.model.gameboard

import domain.model.player.Player

data class Gameboard(
    val houses: List<GameboardHouse>,
    private var currentTurnPlayer: Player? = null
) {
    fun addPlayersIntoStartHouse(players: List<Player>) {
        houses.find { it.kind is GameboardHouseKind.Start }?.players?.addAll(players)
        currentTurnPlayer = players.firstOrNull()
    }

    fun getCurrentTurnPlayer() = currentTurnPlayer
}