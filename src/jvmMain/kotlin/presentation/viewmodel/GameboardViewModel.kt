package presentation.viewmodel

import domain.usecase.GetInitialGameboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GameboardViewModel(
    private val getInitialGameboardUseCase: GetInitialGameboardUseCase
) {

    val state: MutableStateFlow<GameboardContract.State> = MutableStateFlow(GameboardContract.State())

    fun processEvent(event: GameboardContract.Events) {
        when (event) {
            is GameboardContract.Events.InitializeGameboard -> {
                state.update { GameboardContract.State(getInitialGameboardUseCase.execute()) }
            }
        }
    }
}