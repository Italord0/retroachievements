package data

import data.model.Game
import data.model.System
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import util.filterSystems

class RetroachievementsAPIImpl : RetroachievementsAPI {
    private val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = Companion.BASE_URL
                parameters.append("y", Companion.API_KEY)
                parameters.append("z", Companion.USERNAME)
            }
        }
    }

    override suspend fun getAllSystems(): List<System> {
        return client.get("API/API_GetConsoleIDs.php")
            .body<List<System>>()
            .sortedBy { it.name }
            .filterSystems()
    }

    override suspend fun getAllGames(systemId: Int): List<Game> {
        return client.get("API/API_GetGameList.php") {
            parameter("i", systemId)
            parameter("f", 1)
            parameter("h", 1)
        }.body<List<Game>>()
    }

    companion object {
        private const val API_KEY = "LBMIjseJG2wB5jlx3vSmjUhEukMi1JJC"
        private const val BASE_URL = "retroachievements.org"

        //TODO: CHANGE THIS NAME USING PERSISTENCE
        private const val USERNAME = "italord"
    }
}