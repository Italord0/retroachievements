package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RetryButton(onClick: () -> Unit = { }) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface {
            Text("An error has occurred, please try again.")
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(64.dp)
                .clip(RoundedCornerShape(40.dp)),
            onClick = { onClick() }
        ) {
            Text(
                "TRY AGAIN",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Preview
@Composable
fun RetryButtonPreview() {
    RetryButton { }
}