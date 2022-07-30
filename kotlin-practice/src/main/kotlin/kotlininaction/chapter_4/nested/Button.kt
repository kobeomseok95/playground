package kotlininaction.chapter_4.nested

class Button: View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        println("restored.")
    }

    inner class ButtonState: State {
        fun getOuterReference() : Button = this@Button
    }
}