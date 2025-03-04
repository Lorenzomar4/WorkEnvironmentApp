import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.App
import ui.util.swingDefaults


fun main() = application {
    swingDefaults()
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
