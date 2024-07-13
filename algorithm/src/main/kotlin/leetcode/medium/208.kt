package leetcode.medium

class Trie {
    private class TrieNode<T>(
        var parent: T?,
        var children: MutableMap<T, TrieNode<T>> = mutableMapOf()
    ) {
        var isTerminate: Boolean = false
    }

    private val root = TrieNode<Char>(parent = null, children = mutableMapOf())

    fun insert(word: String) {
        var current = root
        word.forEach { char ->
            if (current.children[char] == null) {
                current.children[char] = TrieNode(parent = char, children = mutableMapOf())
            }
            current = current.children[char]!!
        }
        current.isTerminate = true
    }

    fun search(word: String): Boolean {
        var current = findNode(word)
        return current?.isTerminate == true
    }

    private fun findNode(word: String): TrieNode<Char>? {
        var current = root
        word.forEach { char ->
            current.children[char]?.let { node ->
                current = node
            } ?: return null
        }
        return current
    }

    fun startsWith(prefix: String): Boolean {
        val node = findNode(prefix)
        return node?.parent != null
    }
}
