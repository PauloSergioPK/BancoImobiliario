package domain.model.player

import domain.model.colors.GameColor

data class Player(
    val id: Int,
    val bankAccount: BankAccount,
    val color: GameColor
)