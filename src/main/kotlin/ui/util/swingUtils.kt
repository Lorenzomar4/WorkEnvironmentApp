package ui.util


import java.awt.FileDialog
import java.awt.Frame
import javax.swing.JFileChooser
import javax.swing.UIManager

fun swingDefaults() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}


fun selectFolder(): String? {
    val chooser = JFileChooser()
    chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
    chooser.dialogTitle = "Select Folder"

    val returnValue = chooser.showOpenDialog(null)
    return if (returnValue == JFileChooser.APPROVE_OPTION) {
        chooser.selectedFile.absolutePath
    } else {
        null
    }
}





fun selectFolderAwt(): String {
    val frame = Frame()

    val dialog = FileDialog(frame, "Selecciona una carpeta", FileDialog.LOAD)
    dialog.directory = "C:\\"
    dialog.file = "seleccionar_una_carpeta_y_darla_a_abrir"
    dialog.isVisible = true

    val folder = dialog.directory
    frame.dispose() // Cerrar el Frame

    return if (folder != null && folder.isNotEmpty()) {
        folder
    } else {
        ""
    }
}

