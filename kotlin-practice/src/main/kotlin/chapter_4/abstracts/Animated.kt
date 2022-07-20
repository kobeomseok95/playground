package chapter_4.abstracts

class Animated : AbstractAnimated() {
    override fun animate() {
        println("animate")
    }

    override fun stopAnimating() {
        println("Animated Stop Animating")
    }
}