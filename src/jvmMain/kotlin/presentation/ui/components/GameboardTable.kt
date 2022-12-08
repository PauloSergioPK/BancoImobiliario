package presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.gameboard.Gameboard

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
        val gameboardModifier = Modifier
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) { topLine.forEach { GameboardHouseCard(it, gameboardModifier) } }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) { leftLine.forEach { GameboardHouseCard(it, gameboardModifier) } }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) { rightLine.forEach { GameboardHouseCard(it, gameboardModifier) } }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) { bottomLine.forEach { GameboardHouseCard(it, gameboardModifier) } }
    }
}