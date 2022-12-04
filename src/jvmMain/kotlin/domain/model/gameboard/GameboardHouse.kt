package domain.model.gameboard

import domain.model.player.Player

class GameboardHouse(
    val id: String,
    val players: List<Player>,
    val kind: GameboardHouseKind
)