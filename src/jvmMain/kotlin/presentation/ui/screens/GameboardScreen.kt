package presentation.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.ui.components.GameboardTable
import presentation.ui.theme.AppTheme
import presentation.viewmodel.GameboardContract
import presentation.viewmodel.GameboardViewModel

private const val PLAYERS_QUANTITY_BACKGROUND_ALPHA = 0.5F

@Composable
fun CardboardScreen(
    viewModel: GameboardViewModel
) {
    val uiState = viewModel.state.collectAsState().value
    val isPlayersQuantityLayoutVisible = uiState.isPlayersQuantityLayoutVisible
    val playersQuantityInput = uiState.playersQuantityInput
    val isPlayersQuantityErrorVisible = uiState.isPlayersQuantityErrorVisible
    val isConfirmPlayersButtonVisible = uiState.isConfirmPlayersButtonVisible

    GameboardTable(uiState.gameboard)
    PlayersQuantityDialog(
        viewModel = viewModel,
        isPlayersQuantityLayoutVisible = isPlayersQuantityLayoutVisible,
        isPlayersQuantityErrorVisible = isPlayersQuantityErrorVisible,
        playersQuantityInput = playersQuantityInput,
        isConfirmPlayersButtonVisible = isConfirmPlayersButtonVisible
    )
}

@Composable
private fun PlayersQuantityDialog(
    viewModel: GameboardViewModel,
    isPlayersQuantityLayoutVisible: Boolean,
    isPlayersQuantityErrorVisible: Boolean,
    playersQuantityInput: String,
    isConfirmPlayersButtonVisible: Boolean
) {
    AnimatedVisibility(
        visible = isPlayersQuantityLayoutVisible,
        modifier = Modifier.fillMaxSize(),
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Spacer(Modifier.fillMaxSize().alpha(PLAYERS_QUANTITY_BACKGROUND_ALPHA).background(Color.Black))
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
                        onValueChange = {
                            viewModel.processEvent(GameboardContract.Events.OnPlayersQuantityInputChange(it))
                        },
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
                            onClick = { viewModel.processEvent(GameboardContract.Events.ConfirmPlayersQuantity) },
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

