package ui.uiComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.util.colorHexa
import ui.util.selectFolderAwt
import viewModel.DirectoryButtonsVW

@Composable
fun DirectoryButtons(directoryButtonsVW: DirectoryButtonsVW = viewModel()) {
    // Usamos collectAsState() para observar los cambios en StateFlow
    val folderWork by directoryButtonsVW.folderWork.collectAsState()

    Surface(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        color = colorHexa("F5F5F5"),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            folderButton(
                text = "Directorio Apps",
                folderState = folderWork.workspaceApps,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.updateFolder(workspaceApps = selectedFolder)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio Tomcat",
                folderState = folderWork.tomcatFolder,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.updateFolder(tomcatFolder = selectedFolder)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio Opt",
                folderState = folderWork.optFolder,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.updateFolder(optFolder = selectedFolder)
                }
            )
        }
    }
}

@Composable
fun folderButton(
    text: String,
    modifier: Modifier,
    folderState: String, // Cambiamos a String directamente
    directoryButtonsVW: DirectoryButtonsVW,
    updateFolder: (String) -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            val selectedFolder = selectFolderAwt()
            if (selectedFolder.isNotEmpty()) {
                updateFolder(selectedFolder)
                directoryButtonsVW.updateDirectory()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text)
        }
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = folderState,
            onValueChange = {},
            textStyle = TextStyle(color = colorHexa("bfbfbf"), fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic)
        )
    }
}