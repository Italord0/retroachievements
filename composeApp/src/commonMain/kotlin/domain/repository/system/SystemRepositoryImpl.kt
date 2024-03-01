package domain.repository.system

import data.RetroachievementsAPI
import data.model.System

class SystemRepositoryImpl(
    private val retroAPI: RetroachievementsAPI
) : SystemRepository {
    override suspend fun getAllSystems(): Result<List<System>> {
        return kotlin.runCatching {
            retroAPI.getAllSystems()
        }
    }
}