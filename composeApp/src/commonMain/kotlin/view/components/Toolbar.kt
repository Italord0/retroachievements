package view.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun Toolbar(title: String, enableBackButton: Boolean = false, onBackPressed: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            if (enableBackButton) IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}