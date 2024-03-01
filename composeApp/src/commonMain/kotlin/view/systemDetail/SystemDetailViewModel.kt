package view.systemDetail

import data.RetroachievementsAPI
import data.model.Game
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import view.ScreenState

class SystemDetailViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<SystemDetailUIState> = MutableStateFlow(SystemDetailUIState())
    val uiState = _uiState.asStateFlow()

    fun fetchGames(consoleId: Int) {
        viewModelScope.launch {
            try {
                val games = RetroachievementsAPI.client
                    .get("API/API_GetGameList.php") {
                        parameter("i", consoleId)
                        parameter("f", 1)
                        parameter("h", 1)
                    }.body<List<Game>>()
                _uiState.value = SystemDetailUIState(
                    screenState = ScreenState.SUCCESS,
                    games = games
                )
                println(games)
            } catch (e: Exception) {
                // TODO: HANDLE THIS EXCEPTION
                println(e)
                _uiState.value = SystemDetailUIState(
                    screenState = ScreenState.ERROR
                )
            }
        }
    }
}