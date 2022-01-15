package chapter07

fun main() {
    println("프로퍼티 접근자 로직 재활용: 위임 프로퍼티")

    println("\n======== by laze()를 사용한 프로퍼티 초기화 지연")
    val person = Person("leaf", 34)
    println("객체 생성")
    person.emails
    person.emails
}

class Person(val name: String, val age: Int) {
//    private var _emails: List<Email>? = null
//    val emails: List<Email>
//        get() {
//            if (_emails == null) {
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }

    // 위 코드를 by lazy()를 사용하면 간단하게 구현
    val emails by lazy { loadEmails(this) }
}

class Email(val email: String)
fun loadEmails(person: Person): List<Email> {
    println("${person.name} 의 이메일을 가져옴")
    return listOf(Email("leaf@gmail.com"), Email("kis6905@naver.com"))
}
