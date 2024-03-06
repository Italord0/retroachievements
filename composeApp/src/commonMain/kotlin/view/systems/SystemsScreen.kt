package view.systems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.valentinilk.shimmer.shimmer
import view.ScreenState.*
import view.components.LoadingGrid
import view.components.RetryButton
import view.components.SystemCard
import view.systemDetail.SystemDetailScreen


class SystemsScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<SystemsScreenModel>()
        val state: SystemsUiState by screenModel.uiState.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        when (state.screenState) {

            SUCCESS -> {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.systems) { system ->
                        SystemCard(system) {
                            navigator.push(SystemDetailScreen(system = system))
                        }
                    }
                }
            }

            LOADING -> {
                LoadingGrid()
            }

            ERROR -> {
                Row(
                    Modifier.fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RetryButton { screenModel.fetchSystems() }
                }
            }
        }
    }
}