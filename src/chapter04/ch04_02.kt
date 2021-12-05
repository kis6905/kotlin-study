package chapter04

fun main() {
    println("생성자 프로퍼티")

    val user = User("leaf", "iskwon@naver.com")
    println(user.id)
    user.address = "행신동"

}

//class User constructor(_nickname: String) {
//    val nickname: String
//    init {
//        nickname = _nickname
//    }
//}

//class User constructor(_nickname: String) {
//    val nickname = _nickname
//}

open class User(val nickname: String, val email: String = "@", val isSubscribed: Boolean = false) {
    constructor() : this("default") // 부 생성자

    var address: String = "어딘가"
        set(value: String) {
            println("$nickname 의 oldVal: $field, newVal: $value")
            field = value
        }

    var id: String
        get() = email.substringBefore("@")
        set(value: String) { // 프로퍼티 게터 세터에도 접근자를 줄수 있다.
            // read only
        }
}

class TwitterUser(nickname: String): User()
