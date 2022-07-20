package chapter_4.visibility

import chapter_4.interfaces.Focusable

internal open class TalkativeButton : Focusable {
    private fun yell() = println("yell")
    protected fun whisper() = println("whisper")

    fun TalkativeButton.giveSpeech() {  //
        yell()
        whisper()
    }
}

/*
fun TalkativeButton.giveSpeech() {   TalkativeButton은 내부 모듈에서만 접근 가능
    yell()      // private 멤버
    whisper()   // protected 멤버, 확장 함수에서 접근 불가능
}
*/
