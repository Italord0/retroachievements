package data

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
import kotlin.collections.get

object RetroachievementsAPI {
    private const val BASE_URL = "retroachievements.org"
    private const val API_KEY = "LBMIjseJG2wB5jlx3vSmjUhEukMi1JJC"
    const val ASSETS_URL = "https://static.retroachievements.org/assets/images/system/"
    const val IMAGES_URL = "https://media.retroachievements.org"

    //TODO: CHANGE THIS NAME USING PERSISTENCE
    private const val USERNAME = "italord"

    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                parameters.append("y", API_KEY)
                parameters.append("z", USERNAME)
            }
        }
    }

    suspend fun getAllSystems(): List<System> {
        return client.get("API/API_GetConsoleIDs.php").body<List<System>>().sortedBy { it.name }.filterSystems()
    }
}