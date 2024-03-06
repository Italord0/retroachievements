package view.systemDetail

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.RetroachievementsAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import view.ScreenState

class SystemDetailScreenModel(
    private val retroachievementsAPI: RetroachievementsAPI
) : ScreenModel {
    private val _uiState: MutableStateFlow<SystemDetailUIState> = MutableStateFlow(SystemDetailUIState())
    val uiState = _uiState.asStateFlow()

    fun fetchGames(systemId: Int) {
        screenModelScope.launch {
            _uiState.value = SystemDetailUIState(
                screenState = ScreenState.LOADING
            )
            try {
                val games = retroachievementsAPI.getAllGames(systemId)

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