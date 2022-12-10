package presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf

@Immutable
data class AppStrings(
    val startCardTitle: String = "",
    val vacationCardTitle: String = "",
    val jailCardTitle: String = "",
    val goToJailCardTitle: String = "",
    val luckyOrUnluckyCardTitle: String = "",
    val profitsCardTitle: String = "",
    val taxCardTitle: String = "",
    val playersQuantityHint: String = "",
    val playersQuantityError: String = "",
    val confirm: String = "",
    val turnPlayerPlaceholder: String = "",
    val rollDices: String = "",
)

private val LocalAppStrings = compositionLocalOf { AppStrings() }

private val portugueseStrings = AppStrings(
    startCardTitle = "Inicio",
    vacationCardTitle = "Férias",
    jailCardTitle = "Cadeia",
    goToJailCardTitle = "Vá para cadeia",
    luckyOrUnluckyCardTitle = "Sorte ou Revés",
    profitsCardTitle = "Lucros ou Dividendos",
    taxCardTitle = "Imposto de Renda",
    playersQuantityHint = "Digite a quantidade de participantes",
    playersQuantityError = "Quantidade de participantes invalido",
    confirm = "Confirmar",
    turnPlayerPlaceholder = "Vez do jogador: ",
    rollDices = "Jogar dados"
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(LocalAppStrings provides portugueseStrings) {
        MaterialTheme(
            content = content
        )
    }

}

object AppTheme {
    val strings: AppStrings @Composable get() = LocalAppStrings.current
}