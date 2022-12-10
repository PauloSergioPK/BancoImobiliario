package domain.model.player

import domain.model.colors.GameColor

data class Player(
    val bankAccount: BankAccount,
    val color: GameColor
)