package domain.model.gameboard

import domain.model.player.Player

class GameboardHouse(
    val players: List<Player> = listOf(),
    val kind: GameboardHouseKind
)