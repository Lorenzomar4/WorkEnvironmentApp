package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.uiComponents.AppsUi
import ui.uiComponents.InfoDirectoryUi
import ui.uiComponents.DirectoryButtons


@Preview
@Composable
fun App() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            DirectoryButtons()
            AppsUi()
        }
    }
}
