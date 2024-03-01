package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    @SerialName(value = "Title")
    val title: String,
    @SerialName(value = "ID")
    val id: Int,
    @SerialName(value = "ConsoleName")
    val consoleName: String,
    @SerialName(value = "ConsoleID")
    val consoleId: Int,
    @SerialName(value = "ImageIcon")
    val imageIcon: String,
    @SerialName(value = "NumAchievements")
    val numAchievements: Int,
    @SerialName(value = "NumLeaderboards")
    val numLeaderboards: Int,
    @SerialName(value = "Points")
    val points: Int,
    @SerialName(value = "DateModified")
    val dateModified: String,
    @SerialName(value = "ForumTopicID")
    val forumTopicID: Int,
    @SerialName(value = "Hashes")
    val hashes: List<String>
)