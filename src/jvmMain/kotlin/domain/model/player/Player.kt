package domain.model.player

import domain.model.colors.GameColor
import java.io.Serializable

data class Player(
    val id: Int,
    val bankAccount: BankAccount,
    val color: GameColor
): Serializable