package view.systems

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.repository.system.SystemRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import view.ScreenState
import view.ScreenState.ERROR
import view.ScreenState.SUCCESS

class SystemsScreenModel(
    private val systemRepository: SystemRepository
) : ScreenModel {
    private val _uiState: MutableStateFlow<SystemsUiState> = MutableStateFlow(SystemsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchSystems()
    }

    fun fetchSystems() {
        screenModelScope.launch {
            _uiState.value = SystemsUiState(
                screenState = ScreenState.LOADING
            )
            val result = systemRepository.getAllSystems()
            result.onSuccess { systems ->
                _uiState.value = SystemsUiState(
                    screenState = SUCCESS,
                    systems = systems
                )
            }.onFailure { exception ->
                println(exception)
                _uiState.value = SystemsUiState(
                    screenState = ERROR
                )
            }
        }
    }
}