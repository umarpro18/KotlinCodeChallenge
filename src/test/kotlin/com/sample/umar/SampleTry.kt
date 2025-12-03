package com.sample.umar

import java.io.IOException

const val DEFAULT_FILE_NAME = "document"
const val DEFAULT_FILE_EXT = ".tmp"
const val PDF_FILE_EXTENSION = ".pdf"
const val DOT_SEPARATOR = "."
const val DEFAULT_MIME_TYPE = "application/pdf"
const val FILE_EXTENSION_LENGTH = 3

fun main() {
    createEmptyTempFile("umar space äääle.pdf", null)

    println(Test().lambdaSample())
}


class Test {
    val lambdaSample: () -> Unit = { NewData("bobBox", 7) }

    data class NewData(val box: String, val pen: Int)
}


/*private fun File.mimeType(): String? {
    val encodedPath = Uri.encode(this.path)
    val extension = MimeTypeMap.getFileExtensionFromUrl(encodedPath)
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension?.lowercase())
}*/

private fun createEmptyTempFile(fileName: String?, contentType: String?) {
    try {
        val prefix = getFileNamePrefix(fileName)
        val extension = when {
            contentType == DEFAULT_MIME_TYPE -> PDF_FILE_EXTENSION
            fileName != null -> getFileExtension(fileName)
            else -> DEFAULT_FILE_EXT
        }
        println("Final filename and extension -->$prefix--$extension")
    } catch (e: SecurityException) {
        println("Security exception occurred: ${e.message}")
    } catch (e: IOException) {
        println("Security exception occurred: ${e.message}")
    }

}

private fun getFileNamePrefix(fileName: String?): String {
    return fileName?.let {
        val lastDotIndex = it.lastIndexOf(DOT_SEPARATOR)
        it.takeIf { lastDotIndex >= FILE_EXTENSION_LENGTH }?.substring(0, lastDotIndex) ?: DEFAULT_FILE_NAME
    } ?: DEFAULT_FILE_NAME
}

private fun getFileExtension(fileName: String?): String? {
    return fileName?.let { if (it.contains(DOT_SEPARATOR)) it.substring(it.lastIndexOf(DOT_SEPARATOR)) else null }
}