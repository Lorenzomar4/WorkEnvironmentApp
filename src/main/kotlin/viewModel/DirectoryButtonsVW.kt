package viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import config.FolderWork
import java.io.File

class DirectoryButtonsVW : ViewModel() {
    var folderWork = mutableStateOf(FolderWork(workspaceApps = "", tomcatFolder = "", optFolder = ""))

    fun updateDirectory() {
        val objectMapper = jacksonObjectMapper()
        objectMapper.writeValue(File("folderWork.json"), folderWork.value)
    }

    init {
        val objectMapper = ObjectMapper()
        val file = File("folderWork.json")
        val rootNode: JsonNode = objectMapper.readTree(file)

        // Cargar el estado inicial de folderWork desde el archivo
        folderWork.value = FolderWork(
            workspaceApps = rootNode.get("workspaceApps").asText(),
            tomcatFolder = rootNode.get("tomcatFolder").asText(),
            optFolder = rootNode.get("optFolder").asText()
        )
    }
}
