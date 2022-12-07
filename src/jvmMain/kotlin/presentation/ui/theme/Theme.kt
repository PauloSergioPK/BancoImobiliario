package presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf

@Immutable
data class AppStrings(
    val start: String = "",
    val vacation: String = "",
    val jail: String = "",
    val goToJail: String = "",
)

private val LocalAppStrings = compositionLocalOf { AppStrings() }

private val portugueseStrings = AppStrings(
    start = "Inicio",
    vacation = "Férias",
    jail = "Cadeia",
    goToJail = "Vá para cadeia"
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