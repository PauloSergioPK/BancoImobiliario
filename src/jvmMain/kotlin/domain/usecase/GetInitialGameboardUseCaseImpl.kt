package domain.usecase

import domain.model.gameboard.Gameboard
import domain.repository.GameboardRepository

class GetInitialGameboardUseCaseImpl(
    private val repository: GameboardRepository
) : GetInitialGameboardUseCase {

    override fun execute(): Gameboard {
        return repository.getInitialGameboard()
    }
}