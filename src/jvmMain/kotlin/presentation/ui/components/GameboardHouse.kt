package presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.gameboard.GameboardHouse
import domain.model.gameboard.GameboardHouseKind
import domain.model.player.Player
import presentation.ui.theme.*
import presentation.ui.utils.getGameboardHouseCardColorFromGameColor
import java.text.NumberFormat

@Composable
fun GameboardHouseCard(
    gameboardHouse: GameboardHouse,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(0),
        elevation = 0.dp,
        modifier = modifier
    ) {
        CardBackground(gameboardHouse)
        CardPlayers(gameboardHouse.players)
    }
}

@Composable
private fun CardBackground(gameboardHouse: GameboardHouse) {
    val title: String
    val color: Color
    var description = ""

    when (val gameboardHouseKind = gameboardHouse.kind) {
        is GameboardHouseKind.Property -> {
            title = gameboardHouseKind.title
            val value = NumberFormat.getCurrencyInstance().format(gameboardHouseKind.value)
            description = value
            color = getGameboardHouseCardColorFromGameColor(gameboardHouseKind.color)
        }

        is GameboardHouseKind.GoToJail -> {
            title = AppTheme.strings.goToJailCardTitle
            color = Red700
        }

        is GameboardHouseKind.Jail -> {
            title = AppTheme.strings.jailCardTitle
            color = LightBlue700
        }

        is GameboardHouseKind.Start -> {
            title = AppTheme.strings.startCardTitle
            color = DarkBlue700
        }

        is GameboardHouseKind.Vacation -> {
            title = AppTheme.strings.vacationCardTitle
            color = Yellow700
        }

        is GameboardHouseKind.LuckyOrUnlucky -> {
            title = AppTheme.strings.luckyOrUnluckyCardTitle
            color = Yellow700
        }
        is GameboardHouseKind.Profits -> {
            title = AppTheme.strings.profitsCardTitle
            color = Green700
        }
        is GameboardHouseKind.Tax -> {
            title = AppTheme.strings.taxCardTitle
            color = Orange700
        }
    }

    val textColor = if (color.luminance() >= 0.5F) Color.DarkGray else Color.White

    Column(
        modifier = Modifier.fillMaxWidth().background(color).padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val titleStyle = TextStyle(
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        val descriptionStyle = titleStyle.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )

        AutoResizeText(title.uppercase(), style = titleStyle, fontSizeRange = FontSizeRange(min = 12.sp, max = 16.sp), maxLines = 2 )
        if (description.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(description.uppercase(), style = descriptionStyle)
        }
    }

}

@Composable
private fun CardPlayers(
    players: List<Player>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        players.forEach {
            item { Player(it.color) }
        }
    }
}