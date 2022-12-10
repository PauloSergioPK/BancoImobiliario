package presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
@Composable
fun TranslucentBackground() {
    Spacer(Modifier.fillMaxSize().alpha(0.5F).background(Color.Black))
}