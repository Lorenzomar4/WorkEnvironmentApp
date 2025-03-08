package ui.uiComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import ui.util.colorHexa
import ui.util.selectFolder
import ui.util.selectFolderAwt
import viewModel.DirectoryButtonsVW
import java.io.File
import javax.swing.SwingUtilities

@Composable
fun DirectoryButtons(directoryButtonsVW: DirectoryButtonsVW = viewModel()) {
    val folderWork by directoryButtonsVW.folderWork.collectAsState()

    // Estados para almacenar las carpetas seleccionadas
    val dataSourceFolder = remember { mutableStateOf(folderWork.dataSourceFolder) }
    val webAppsFolder = remember { mutableStateOf(folderWork.webAppsFolder) }
    val configTomcat = remember { mutableStateOf(folderWork.configTomcat) }

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
                text = "Directorio del datasource",
                folderState = dataSourceFolder,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW
            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio webApps",
                folderState = webAppsFolder,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW

            )
            Spacer(modifier = Modifier.width(8.dp))

            folderButton(
                text = "Directorio config tomcat",
                folderState = configTomcat,
                modifier = Modifier.weight(1f),
                directoryButtonsVW = directoryButtonsVW
            )
        }
    }
}

@Composable
fun folderButton(
    text: String,
    modifier: Modifier,
    folderState: MutableState<String> ,
    directoryButtonsVW: DirectoryButtonsVW
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            val selectedFolder = selectFolderAwt()
            if (selectedFolder.isNotEmpty()) {
                folderState.value = selectedFolder
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
