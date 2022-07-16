import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main() {
    val no = BufferedReader(StringReader("a"))
    readNumber(no)
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {

    }
    println(number)
}
