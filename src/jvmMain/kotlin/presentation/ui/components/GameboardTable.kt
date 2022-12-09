package presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import domain.model.gameboard.Gameboard
import presentation.APP_NAME

@Composable
fun GameboardTable(
    gameboard: Gameboard,
    modifier: Modifier = Modifier
) {
    val bottomLine = gameboard.houses.take(11).reversed()
    val leftLine = gameboard.houses.drop(11).take(9).reversed()
    val topLine = gameboard.houses.drop(11).drop(9).take(11)
    val rightLine = gameboard.houses.drop(11).drop(9).drop(11).take(9)

    BoxWithConstraints(modifier = Modifier.fillMaxSize().then(modifier)) {

        Column(modifier = Modifier.fillMaxSize()) {

            val cardModifier =  Modifier.fillMaxSize().border(BorderStroke(1.dp, Color.Black)).weight(1F)

            Row(
                modifier = Modifier.fillMaxWidth().weight(0.1F),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) { topLine.forEach { GameboardHouseCard(it, cardModifier) } }

            Row(modifier = Modifier.fillMaxSize().weight(0.8F), horizontalArrangement = Arrangement.SpaceBetween) {
                val columnModifier = Modifier.fillMaxHeight().weight(0.112F)
                Column(
                    modifier = columnModifier,
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) { leftLine.forEach { GameboardHouseCard(it,cardModifier) } }

                Box(
                    modifier = Modifier.fillMaxHeight().weight(1F).background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(APP_NAME)
                }

                Column(
                    modifier = columnModifier,
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) { rightLine.forEach { GameboardHouseCard(it,cardModifier) } }
            }

            Row(
                modifier = Modifier.fillMaxWidth().weight(0.1F),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) { bottomLine.forEach { GameboardHouseCard(it,cardModifier) } }
        }
    }
}