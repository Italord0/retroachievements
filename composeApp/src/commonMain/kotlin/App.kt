import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import di.sharedModule
import di.systemModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import view.systems.SystemsScreen

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(sharedModule, systemModule)
    }) {
        MaterialTheme(
            colors = if (isSystemInDarkTheme()) darkColors(background = Color.Black) else lightColors()
        ) {
            Navigator(SystemsScreen())
        }
    }
}