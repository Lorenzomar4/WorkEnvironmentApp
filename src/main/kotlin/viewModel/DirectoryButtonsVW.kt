package viewModel

import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import config.FolderWork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class DirectoryButtonsVW : ViewModel() {
    private val _folderWork: MutableStateFlow<FolderWork> =
        MutableStateFlow(FolderWork(dataSourceFolder = "", webAppsFolder = "", configTomcat = ""))

    val folderWork: StateFlow<FolderWork> = _folderWork


    fun updateDirectory() {
        val file = File("folderWork.json")
        val objectMapper = jacksonObjectMapper()

        // Serializar el valor actual dentro de _folderWork
        objectMapper.writeValue(file, _folderWork.value)

        val anotherFile = File("anotherFile.json")
        // Si no existe, lo crea, sino lo sobrescribe con un nuevo contenido
        objectMapper.writeValue(anotherFile, _folderWork.value)
    }

    init {
        val objectMapper = ObjectMapper()
        val file = File("folderWork.json")
        val rootNode: JsonNode = objectMapper.readTree(file)

        val dataSourceFolder = rootNode.get("dataSourceFolder").asText()
        val webAppsFolder = rootNode.get("webAppsFolder").asText()
        val configTomcat = rootNode.get("configTomcat").asText()

        _folderWork.value = FolderWork(
            dataSourceFolder = dataSourceFolder,
            webAppsFolder = webAppsFolder,
            configTomcat = configTomcat
        )
    }
}
