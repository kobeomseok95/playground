fun <T>println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
