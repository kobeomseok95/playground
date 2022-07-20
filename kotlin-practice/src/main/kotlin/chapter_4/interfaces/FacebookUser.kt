package chapter_4.interfaces

class FacebookUser(val accountId: Long) : User {
    // 프로퍼티 초기화 식
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Long): String {
        return "facebookNickname"
    }
}