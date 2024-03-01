package view.systemDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import view.ScreenState
import view.components.GameCard

data class SystemDetailScreen(val systemId: Int) : Screen {
    @Composable
    override fun Content() {

        val viewModel: SystemDetailViewModel = getViewModel(Unit, viewModelFactory { SystemDetailViewModel() })
        val state: SystemDetailUIState by viewModel.uiState.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.fetchGames(systemId)
        }

        when (state.screenState) {
            ScreenState.SUCCESS -> {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.games) { game ->
                        GameCard(game) {
                            println(it)
                        }
                    }
                }
            }

            ScreenState.LOADING -> {}
            ScreenState.ERROR -> {}
        }
    }
}