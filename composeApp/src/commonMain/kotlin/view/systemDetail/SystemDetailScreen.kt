package view.systemDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.model.System
import view.ScreenState
import view.components.GameCard
import view.components.LoadingGrid
import view.components.RetryButton
import view.components.Toolbar

data class SystemDetailScreen(val system: System) : Screen {
    @Composable
    override fun Content() {

        val screenModel: SystemDetailScreenModel = getScreenModel<SystemDetailScreenModel>()
        val state: SystemDetailUIState by screenModel.uiState.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            screenModel.fetchGames(system.id)
        }

        when (state.screenState) {
            ScreenState.SUCCESS -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    Toolbar(title = system.name, enableBackButton = true, onBackPressed = { navigator.pop() })
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxSize(),
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
            }

            ScreenState.LOADING -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    Toolbar(title = system.name, enableBackButton = true, onBackPressed = { navigator.pop() })
                    LoadingGrid()
                }
            }

            ScreenState.ERROR -> {
                Row(
                    Modifier.fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RetryButton { screenModel.fetchGames(system.id) }
                }
            }
        }
    }
}