package domain.repository.system

import data.model.System

interface SystemRepository {
    suspend fun getAllSystems(): Result<List<System>>
}