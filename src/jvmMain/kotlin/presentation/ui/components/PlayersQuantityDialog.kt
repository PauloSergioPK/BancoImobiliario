package presentation.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.ui.theme.AppTheme


@Composable
fun PlayersQuantityDialog(
    onValueChanged: (String) -> Unit,
    isPlayersQuantityLayoutVisible: Boolean,
    isPlayersQuantityErrorVisible: Boolean,
    playersQuantityInput: String,
    isConfirmPlayersButtonVisible: Boolean,
    onConfirmQuantityClicked: () -> Unit
) {
    AnimatedVisibility(
        visible = isPlayersQuantityLayoutVisible,
        modifier = Modifier.fillMaxSize(),
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        TranslucentBackground()
        BoxWithConstraints(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val cardWidth = (maxWidth.value * 0.3).dp
            Card(shape = RoundedCornerShape(8), modifier = Modifier.width(cardWidth)) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        AppTheme.strings.playersQuantityHint,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                    Spacer(Modifier.height(16.dp))
                    OutlinedTextField(
                        value = playersQuantityInput,
                        onValueChange = onValueChanged,
                        singleLine = true
                    )
                    Spacer(Modifier.height(16.dp))
                    AnimatedVisibility(isPlayersQuantityErrorVisible) {
                        Text(
                            AppTheme.strings.playersQuantityError,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colors.error
                            )
                        )
                    }
                    AnimatedVisibility(isConfirmPlayersButtonVisible) {
                        Button(
                            onClick = onConfirmQuantityClicked,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                AppTheme.strings.confirm,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colors.onPrimary
                                )
                            )
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}
