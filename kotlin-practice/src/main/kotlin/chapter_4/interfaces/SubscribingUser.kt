package chapter_4.interfaces

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@")
}