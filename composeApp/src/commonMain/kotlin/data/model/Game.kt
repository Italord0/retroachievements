package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    @SerialName(value = "Title")
    val title: String = "",
    @SerialName(value = "ID")
    val id: Int = 0,
    @SerialName(value = "ConsoleName")
    val consoleName: String = "",
    @SerialName(value = "ConsoleID")
    val consoleId: Int = 0,
    @SerialName(value = "ImageIcon")
    val imageIcon: String = "",
    @SerialName(value = "NumAchievements")
    val numAchievements: Int = 0,
    @SerialName(value = "NumLeaderboards")
    val numLeaderboards: Int = 0,
    @SerialName(value = "Points")
    val points: Int = 0,
    @SerialName(value = "DateModified")
    val dateModified: String = "",
    @SerialName(value = "ForumTopicID")
    val forumTopicID: Int = 0,
    @SerialName(value = "Hashes")
    val hashes: List<String> = emptyList()
)
