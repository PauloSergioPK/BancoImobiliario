package presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import domain.model.gameboard.Gameboard

@Composable
fun GameboardTable(
    gameboard: Gameboard,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(rows = GridCells.Fixed(11), modifier = Modifier.fillMaxSize()) {
        gameboard.houses.forEach {
            item { GameboardHouseCard(it) }
        }
    }
}