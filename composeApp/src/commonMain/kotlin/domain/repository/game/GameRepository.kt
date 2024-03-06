package domain.repository.game

import data.model.Game

interface GameRepository {
    suspend fun getAllGames(systemId: Int): Result<List<Game>>
}