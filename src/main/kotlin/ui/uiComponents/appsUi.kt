package ui.uiComponents

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.application
import model.Aplication
import ui.util.Colores
import ui.util.colorHexa

@Composable
fun AppsUi() {
    var query by remember { mutableStateOf("") }

    Surface(color = Colores.gray(), modifier = Modifier.padding(16.dp).fillMaxWidth(), elevation = 3.dp) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Aplicaciones", color = Color.Gray)
                Column() {
                    Select()

                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Buscar") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Icono de búsqueda",
                        tint = Color.Gray
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            AppOptions()

        }
    }
}
@Preview
@Composable
fun AppOptions() {
    var state by remember { mutableStateOf(false) }
    val lista = examples()




    Encabezado()
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Permite que LazyColumn ocupe todo el espacio disponible
        ) {
            // Fila de encabezados con estilo


            // Filas de datos con scroll
            items(lista) { theAplication ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = theAplication.activate,
                        onCheckedChange = { state = it },
                        modifier = Modifier
                            .weight(0.2f)
                            .align(Alignment.CenterVertically)
                    )

                    Text(
                        text = theAplication.aplicationName!!,
                        maxLines = 1,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )

                    Text(
                        text = theAplication.instance!!,
                        maxLines = 1,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                }
                Divider()
            }
        }

        // Botones de confirmación/cancelación siempre visibles
        ConfirmOrCancel()
    }
}


@Composable
fun ConfirmOrCancel() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorHexa("e72a52"), contentColor = Color.White)) {
            Text(text = "Cancelar")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorHexa("2aabe7"), contentColor = Color.White)) {
            Text(text = "Aceptar")
        }
    }
}


fun examples(): List<Aplication> {
    val applications = listOf(
        Aplication().apply {
            dataSource = "MySQL_DB"
            activate = true
            aplicationName = "App__1"
            obligatory = true
            instance = "I01"
        },
        Aplication().apply {
            dataSource = "PostgreSQL_DB"
            activate = false
            aplicationName = "App__2"
            obligatory = false
            instance = "I02"
        },
        Aplication().apply {
            dataSource = "SQLServer_DB"
            activate = true
            aplicationName = "App__3"
            obligatory = true
            instance = "I03"
        },
        Aplication().apply {
            dataSource = "Oracle_DB"
            activate = false
            aplicationName = "App__5"
            obligatory = false
            instance = "I04"
        },
        Aplication().apply {
            dataSource = "Oracle_DB"
            activate = false
            aplicationName = "App__6"
            obligatory = false
            instance = "I04"
        },
        Aplication().apply {
            dataSource = "Oracle_DB"
            activate = false
            aplicationName = "App__7"
            obligatory = false
            instance = "I04"
        },
        Aplication().apply {
            dataSource = "Oracle_DB"
            activate = false
            aplicationName = "App__8"
            obligatory = false
            instance = "I04"
        },
        Aplication().apply {
            dataSource = "Oracle_DB"
            activate = false
            aplicationName = "App__9"
            obligatory = false
            instance = "I04"
        },
        Aplication().apply {
            dataSource = "MongoDB_DB"
            activate = true
            aplicationName = "App__10"
            obligatory = true
            instance = "I05"
        }

    )

    return applications
}

@Composable
fun Encabezado(){
    val txtStyle: TextStyle =
        TextStyle(fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal)

    Spacer(modifier = Modifier.height(16.dp));

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorHexa("2a0024"))
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(0.2f)
        ) {
            Text(
                text = "Activar",
                style = txtStyle,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "Aplicación",
            style = txtStyle,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )

        Text(
            text = "Instancia",
            style = txtStyle,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
    }
    Divider(color = Color.DarkGray, thickness = 1.dp)
}