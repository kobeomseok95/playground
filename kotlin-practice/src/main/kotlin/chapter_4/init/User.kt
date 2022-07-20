package chapter_4.init

class User private constructor(val nickname: String) {

    companion object UserFactory {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore("@"))
        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))

        private fun getFacebookName(facebookAccountId: Int): String {
            return "facebookId"
        }
    }

    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed $nickname:
                "$field" -> "$value".
            """.trimIndent())
            field = value
        }
}