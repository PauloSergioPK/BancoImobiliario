package presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import domain.model.gameboard.Gameboard
import presentation.APP_NAME

@Composable
fun GameboardTable(
    gameboard: Gameboard,
    modifier: Modifier = Modifier
) {
    val bottomLine = gameboard.houses.take(11).reversed()
    val leftLine = gameboard.houses.drop(11).take(10).reversed()
    val topLine = gameboard.houses.drop(11).drop(10).take(11)
    val rightLine = gameboard.houses.drop(11).drop(10).drop(11).take(10)

    BoxWithConstraints(modifier = Modifier.fillMaxSize().then(modifier)) {

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().weight(0.15F),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) { topLine.forEach { GameboardHouseCard(it, Modifier.fillMaxHeight().weight(1F)) } }

            Row(modifier = Modifier.fillMaxSize().weight(1F), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    modifier = Modifier.fillMaxHeight().weight(0.15F),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) { leftLine.forEach { GameboardHouseCard(it, Modifier.weight(0.2F)) } }

                Box(
                    modifier = Modifier.fillMaxHeight().weight(0.7F).background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(APP_NAME)
                }

                Column(
                    modifier = Modifier.fillMaxHeight().weight(0.15F),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) { rightLine.forEach { GameboardHouseCard(it, Modifier.weight(0.2F)) } }
            }

            Row(
                modifier = Modifier.fillMaxWidth().weight(0.15F),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) { bottomLine.forEach { GameboardHouseCard(it, Modifier.fillMaxHeight().weight(1F)) } }
        }
    }
}