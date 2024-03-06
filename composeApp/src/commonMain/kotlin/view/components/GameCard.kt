package view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Game
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import util.Constants.IMAGES_URL

@Composable
fun GameCard(game: Game, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .height(160.dp)
            .width(30.dp)
            .clickable { onClick(game.id) }
    ) {
        Column {
            KamelImage(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                resource = asyncPainterResource(data = "$IMAGES_URL${game.imageIcon}"),
                contentDescription = "${game.title} image"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
                text = game.title,
                maxLines = 2,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "🏆 ${game.numAchievements}")
                Text(text = "⭐ ${game.points}")
            }
        }
    }
}