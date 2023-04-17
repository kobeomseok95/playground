import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main(): Unit = runBlocking {
    withTimeoutOrNull(300) {
        simpleFlowWithTimeout().collect { println(it) }
    }
    println("Done!")
}

fun simpleSequence(): Sequence<Int> = sequence {
    for (i in 1..5) {
        Thread.sleep(1000)
        yield(i)
    }
}

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun simpleFlow2(): Flow<Int> = flow {
    println("Flow Started...")
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}

fun simpleFlowWithTimeout(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(100)
        println("emitting $i")
        emit(i)
    }
}
