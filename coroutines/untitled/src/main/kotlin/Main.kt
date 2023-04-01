import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    coroutine()
}

private fun coroutine() {
    runBlocking {
        launch {
            repeat(5) { i ->
                println("Coroutine A, $i")
                delay(10L)
            }
        }

        launch {
            repeat(5) { i ->
                println("Coroutine B, $i")
                delay(10L)
            }
        }
        println("Coroutine Outer")
    }
}
