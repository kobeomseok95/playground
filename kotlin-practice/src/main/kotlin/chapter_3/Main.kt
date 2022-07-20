package chapter_3


fun main() {
    val possibleUser = User(1, "고범석", "서울 광진구 중곡동")
    saveUser(possibleUser)

    val impossibleUser = User(2, "   ", "   ")
    saveUser(impossibleUser)
}

fun saveUser(user: User) {
    fun validate(
        value: String,
        fieldName: String,
    ) {
        if (value.isBlank()) {
            throw IllegalArgumentException(fieldName + "이 없습니다.")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    println("저장 완료")
}
