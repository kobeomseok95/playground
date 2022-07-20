package chapter_4

import chapter_4.init.User

fun main() {
    println(User.newFacebookUser(1).nickname)
    println(User.newSubscribingUser("kobumssh@naver.com").nickname)
    println(User.googleUser("ga@gmail.com").nickname)
}

fun User.UserFactory.googleUser(email: String): User = User.newSubscribingUser("google" + email)
