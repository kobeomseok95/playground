package kotlininaction.chapter_4.interfaces

class Button : Clickable, Focusable {
    override fun click() = println("i was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}