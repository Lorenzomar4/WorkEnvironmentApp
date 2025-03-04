package ui.util

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