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

    fun advancePlayerInGameboard(playerId: Int, housesCount: Int) {
        val currentHouseIndex = houses.indexOfFirst { house -> house.players.any { it.id == playerId } }
        if (currentHouseIndex != -1) {
            val player = houses[currentHouseIndex].players.find { it.id == playerId }!!
            houses[currentHouseIndex].removePlayerInHouse(playerId)
            houses[(currentHouseIndex + housesCount) % houses.size].addPlayerInHouse(player)
        }
    }

    fun getCurrentTurnPlayer() = currentTurnPlayer
}