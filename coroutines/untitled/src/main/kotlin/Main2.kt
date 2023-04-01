import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main(): Unit = runBlocking {
    withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
}
