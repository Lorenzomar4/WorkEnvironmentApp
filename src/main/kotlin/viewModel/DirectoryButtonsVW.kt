package viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import config.FolderWork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File

class DirectoryButtonsVW : ViewModel() {
    private val _folderWork = MutableStateFlow(FolderWork(workspaceApps = "", tomcatFolder = "", optFolder = ""))
    val folderWork: StateFlow<FolderWork> get() = _folderWork

    fun updateDirectory() {
        val objectMapper = jacksonObjectMapper()
        objectMapper.writeValue(File("folderWork.json"), _folderWork.value)
    }

    init {
        val objectMapper = ObjectMapper()
        val file = File("folderWork.json")
        if (file.exists()) {
            val rootNode: JsonNode = objectMapper.readTree(file)

            // Cargar el estado inicial de folderWork desde el archivo
            _folderWork.value = FolderWork(
                workspaceApps = rootNode.get("workspaceApps").asText(),
                tomcatFolder = rootNode.get("tomcatFolder").asText(),
                optFolder = rootNode.get("optFolder").asText()
            )
        }
    }

    fun updateFolder(workspaceApps: String = _folderWork.value.workspaceApps,
                     tomcatFolder: String = _folderWork.value.tomcatFolder,
                     optFolder: String = _folderWork.value.optFolder) {
        _folderWork.value = FolderWork(workspaceApps, tomcatFolder, optFolder)
    }
}
