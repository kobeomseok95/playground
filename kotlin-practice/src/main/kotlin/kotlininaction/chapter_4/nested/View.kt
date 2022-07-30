package kotlininaction.chapter_4.nested

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}