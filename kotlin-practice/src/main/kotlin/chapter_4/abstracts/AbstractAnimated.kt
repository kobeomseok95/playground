package chapter_4.abstracts

abstract class AbstractAnimated {
    abstract fun animate()

    open fun stopAnimating() {
        println("AbstractAnimated Stop Animating")
    }

    fun animateTwice() {
        // open 키워드가 없어 override 불가능
    }
}