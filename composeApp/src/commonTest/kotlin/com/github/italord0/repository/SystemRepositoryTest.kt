package com.github.italord0.repository

import data.RetroachievementsAPI
import data.model.Game
import data.model.System
import domain.repository.system.SystemRepositoryImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class SystemRepositoryTest {
    class TestRetroachievementsAPI(private val systems: List<System>, private val games: List<Game>) :
        RetroachievementsAPI {
        override suspend fun getAllSystems(): List<System> {
            return systems
        }

        override suspend fun getAllGames(systemId: Int): List<Game> {
            return games
        }
    }

    @Test
    fun `GetAllSystems should return Result success`() {
        // Given
        val systems = listOf(
            System(1, "System 1"),
            System(2, "System 2"),
            System(3, "System 3")
        )
        val games = listOf(
            Game(id = 1),
            Game(id = 2),
            Game(id = 3)
        )
        val retroAPI = TestRetroachievementsAPI(systems, games)
        val systemRepository = SystemRepositoryImpl(retroAPI)

        // When
        val result = runBlocking { systemRepository.getAllSystems() }

        // Then
        assertEquals(Result.success(systems), result)
    }

    // Test case for handling exception during system retrieval
    @Test
    fun `GetAllSystems should return Result failure`() {
        // Given
        val expectedException = RuntimeException("Failed to retrieve systems")
        val retroAPI = object : RetroachievementsAPI {
            override suspend fun getAllSystems(): List<System> {
                throw expectedException
            }

            override suspend fun getAllGames(systemId: Int): List<Game> {
                throw expectedException
            }
        }
        val systemRepository = SystemRepositoryImpl(retroAPI)

        // When
        val result = runBlocking { systemRepository.getAllSystems() }

        // Then
        assertEquals(Result.failure(expectedException), result)
    }
}
