package chapter_3.strings

class ParsePath {

    fun parsePath(path: String) : FileData {
        val directory = path.substringBeforeLast("/")
        val fullName = path.substringAfterLast("/")
        val fileName = fullName.substringBeforeLast(".")
        val extension = fullName.substringAfterLast(".")
        return FileData(directory, fullName, fileName, extension)
    }
}