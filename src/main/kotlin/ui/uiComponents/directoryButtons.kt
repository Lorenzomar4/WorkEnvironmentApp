package ui.uiComponents

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.util.colorHexa

@Composable
fun DirectoryButtons() {
    // Utilizamos Surface para envolver el Row y aplicar una elevación (sombra)
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


            folderButton("Directorio del datasource" , modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))

            folderButton("Directorio webApps" , modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))

            folderButton("Directorio config tomcat" , modifier = Modifier.weight(1f))

        }
    }

}

@Composable
fun folderButton(text : String ,modifier: Modifier){
    Button(onClick = {}, modifier =modifier ) {
        Text(text)
    }

}