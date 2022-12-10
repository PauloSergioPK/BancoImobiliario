package presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.player.Player
import presentation.ui.theme.AppTheme

@Composable
fun TurnPlayerDialog(player: Player, onRollDicesClicked: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    var isDicesVisible by rememberSaveable { mutableStateOf(false) }

    BoxWithConstraints(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        TranslucentBackground()
        val cardWidth = (maxWidth.value * 0.3).dp
        Card(shape = RoundedCornerShape(8), modifier = Modifier.width(cardWidth)) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${AppTheme.strings.turnPlayerPlaceholder} ${player.id + 1}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.onSurface
                    )
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = onRollDicesClicked,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        AppTheme.strings.rollDices,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.onPrimary
                        )
                    )
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}