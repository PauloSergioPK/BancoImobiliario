package domain.model.gameboard

import domain.model.player.Player

data class Gameboard(
    val houses: List<GameboardHouse>
) {
    fun addPlayersIntoStartHouse(players: List<Player>) {
        houses.find { it.kind is GameboardHouseKind.Start }?.players?.addAll(players)
    }
}