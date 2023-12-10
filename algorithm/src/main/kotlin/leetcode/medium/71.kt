package leetcode.medium

import java.util.Stack

class `71` {
    fun simplifyPath(path: String): String {
        val parts = path.split(SLASH)
        val directoryNames = Stack<String>()

        parts.forEach { part ->
            when (part) {
                CURRENT_DIR, EMPTY_STRING -> { /* no-op */ }
                PREVIOUS_DIR -> directoryNames.takeIf { it.isNotEmpty() }?.run { pop() }
                else -> directoryNames.add(part)
            }
        }

        return directoryNames.joinToString(separator = SLASH, prefix = SLASH)
    }

    companion object {
        private const val SLASH = "/"
        private const val PREVIOUS_DIR = ".."
        private const val CURRENT_DIR = "."
        private const val EMPTY_STRING = ""
    }
}

fun main() {
    `71`().simplifyPath(path = "/home/").apply(::println)
    println()
    `71`().simplifyPath(path = "/../").apply(::println)
    println()
    `71`().simplifyPath(path = "/home//foo/").apply(::println)
    println()
    `71`().simplifyPath(path = "/home/foo/../..").apply(::println)
    println()
    `71`().simplifyPath(path = "/a/./b/../../c/").apply(::println)
    println()
    `71`().simplifyPath(path = "/a/../../b/../c//.//").apply(::println)
}
