package data

import data.model.Game
import data.model.System

interface RetroachievementsAPI {
    suspend fun getAllSystems(): List<System>
    suspend fun getAllGames(systemId: Int): List<Game>
}