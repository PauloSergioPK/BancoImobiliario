package domain.model.gameboard

import domain.model.colors.GameColor
import domain.model.player.Player

sealed interface GameboardHouseKind {
    object Start: GameboardHouseKind

    object Jail: GameboardHouseKind

    object GoToJail: GameboardHouseKind

    object Vacation: GameboardHouseKind

    data class Property(
        val title: String,
        val value: Float,
        val color: GameColor,
        val owner: Player? = null
    ): GameboardHouseKind
}