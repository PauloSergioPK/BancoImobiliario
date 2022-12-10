package domain.model.gameboard

import domain.model.player.Player

class GameboardHouse(
    val players: MutableList<Player> = mutableListOf(),
    val kind: GameboardHouseKind
) {

    fun addPlayerInHouse(player: Player) {
        players.add(player)
    }
    fun removePlayerInHouse(playerId: Int) {
        players.removeIf { it.id == playerId }
    }
}