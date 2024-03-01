package view.systemDetail

import data.model.Game
import view.ScreenState
import view.ScreenState.LOADING

data class SystemDetailUIState(
    val screenState: ScreenState = LOADING,
    val games: List<Game> = listOf()
)