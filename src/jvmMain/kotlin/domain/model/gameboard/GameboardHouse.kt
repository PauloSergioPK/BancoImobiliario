package domain.model.gameboard

import domain.model.player.Player

class GameboardHouse(
    val players: MutableList<Player> = mutableListOf(),
    val kind: GameboardHouseKind
)