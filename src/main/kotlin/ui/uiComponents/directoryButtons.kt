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
    val folderWork by directoryButtonsVW.folderWork

    Surface(
        elevation = 4.dp, // Ajusta la elevación según el efecto deseado
        shape = MaterialTheme.shapes.medium, // Define la forma de los bordes
        color = colorHexa("F5F5F5"), // Color de fondo
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Padding interno del Surface
            horizontalArrangement = Arrangement.Center
        ) {
            folderButton(
                text = "Directorio Apps",
                folderState = remember { mutableStateOf(folderWork.workspaceApps) },
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.folderWork.value = directoryButtonsVW.folderWork.value.copy(workspaceApps = selectedFolder)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio Tomcat",
                folderState = remember { mutableStateOf(folderWork.tomcatFolder) },
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.folderWork.value = directoryButtonsVW.folderWork.value.copy(tomcatFolder = selectedFolder)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio Opt",
                folderState = remember { mutableStateOf(folderWork.optFolder) },
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW,
                updateFolder = { selectedFolder ->
                    directoryButtonsVW.folderWork.value = directoryButtonsVW.folderWork.value.copy(optFolder = selectedFolder)
                }
            )
        }
    }
}

@Composable
fun folderButton(
    text: String,
    modifier: Modifier,
    folderState: MutableState<String>,
    directoryButtonsVW: DirectoryButtonsVW,
    updateFolder: (String) -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            val selectedFolder = selectFolderAwt()
            if (selectedFolder.isNotEmpty()) {
                folderState.value = selectedFolder
                updateFolder(selectedFolder)
                directoryButtonsVW.updateDirectory()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text)
        }
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = folderState.value,
            onValueChange = {},
            textStyle = TextStyle(color = colorHexa("bfbfbf"), fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic)
        )
    }
}