package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadingGrid() {
    LazyVerticalGrid(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(top = 8.dp)
            .fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) {
            Card(
                modifier = Modifier
                    .height(120.dp)
                    .width(30.dp)
                    .shimmer()
            ) {}
        }
    }
}