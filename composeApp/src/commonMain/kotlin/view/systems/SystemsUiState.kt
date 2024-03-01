package view.systems

import data.model.System
import view.ScreenState
import view.ScreenState.LOADING

data class SystemsUiState(
    val screenState: ScreenState = LOADING,
    val systems: List<System> = listOf()
)