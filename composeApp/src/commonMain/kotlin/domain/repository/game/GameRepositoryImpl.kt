package domain.repository.game

import data.RetroachievementsAPI
import data.model.Game

class GameRepositoryImpl(
    private val retroachievementsAPI: RetroachievementsAPI
) : GameRepository {
    override suspend fun getAllGames(systemId: Int): Result<List<Game>> {
        return kotlin.runCatching {
            retroachievementsAPI.getAllGames(systemId)
        }
    }

}