package ui.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.util.Colores

@Composable
fun InfoDirectoryUi() {

    Surface(color = Colores.gray(), modifier = Modifier.padding(16.dp).fillMaxWidth(), elevation = 3.dp) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {

            Select()

        }


    }

}

@Composable
fun Select() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Texto") }
    val desserts = listOf("DESA", "TEST", "PROD")
    Row {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            label = { Text(text="Ambiente")},
            modifier = Modifier
                .wrapContentSize()
                .height(56.dp)
                .width(150.dp)
                .clickable { expanded = true },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                focusedBorderColor = Color.Red

            ),
            textStyle = TextStyle(fontSize = 12.sp)

        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

            ) {
            desserts.forEach() { desert ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = desert
                    }
                ) {
                    Text(text = desert)
                }
            }
        }


    }



}