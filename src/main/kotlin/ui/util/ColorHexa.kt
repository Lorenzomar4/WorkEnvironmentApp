package ui.util

import androidx.compose.ui.graphics.Color


fun colorHexa(number: String): Color {
    // Asegurarse de que la cadena tenga exactamente 6 caracteres hexadecimales
    val colorInt = number.toIntOrNull(16)?.let { 0xFF000000.toInt() or it }
        ?: throw IllegalArgumentException("Invalid hex code")

    return Color(colorInt)
}