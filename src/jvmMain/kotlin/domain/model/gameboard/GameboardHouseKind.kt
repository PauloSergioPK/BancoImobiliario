package domain.model.gameboard

import domain.model.colors.GameColor
import domain.model.player.Player

sealed interface GameboardHouseKind {
    data class Start(val bonus: Float): GameboardHouseKind

    object Jail: GameboardHouseKind

    object GoToJail: GameboardHouseKind

    object Vacation: GameboardHouseKind

    object LuckyOrUnlucky: GameboardHouseKind

    data class Profits(val quantity: Float): GameboardHouseKind

    data class Tax(val quantity: Float): GameboardHouseKind

    data class Property(
        val title: String,
        val value: Float,
        val color: GameColor,
        val owner: Player? = null,
        val imageResourceName: String? = null
    ): GameboardHouseKind
}