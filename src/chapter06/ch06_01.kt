package chapter06

import java.lang.IllegalArgumentException

fun main() {
    println("널 가능성")

    // null 이 될 수 있는 타입
    println("\n===== null 이 될 수 있는 타입")
    val strLen = { s: String -> s.length } // null 불가능
//    strLen(null) // 컴파일 에러
    var aa: String? = "123"
    if (aa != null) // null 체크를 하면 notnull 처럼 사용할수 있다
        println(strLen(aa))

    val strLenSafe = { s: String? -> if (s!= null) s.length else 0 } // null 이 올 수 있기때문에 체크
    println(strLenSafe(null))


    // 안전한 호출 연산자: ?.
    println("\n===== 안전한 호출 연산자")
    val printAllCaps = { s: String? ->
        val allCaps: String? = s?.uppercase()
        println(allCaps)
    }
    printAllCaps("hello")
    printAllCaps(null)
    
    val person = Person("Leaf", null)
    println(person.company?.name?.length) // 연쇄 사용 가능
    
    // 엘비스 연산자: ?:
    println("\n===== 엘비스 연산자")
    val foo = { s: String? -> s ?: "empty" }
    println(foo("hi"))
    println(foo(null))

    val strLenSafe2 = { s:String? -> s?.length ?: 0 }
    println(strLenSafe2("leaf"))
    println(strLenSafe2(null))

//    val strLenSafe3 = { s:String? -> s?.length ?: throw IllegalArgumentException("null!!") } // throw Exception 도 가능
//    println(strLenSafe3(null))

    // 안전한 캐스트: as?
    println("\n===== 안전한 캐스트")
    val person1 = Person("leaf", null)
    val person2 = Person("leaf", null)
    println(person1.equals(person2))
    println(person1.equals(null))

    // 널 아님 단언: !!
    println("\n===== 널 아님 단언")
    val ignoreNulls = { s: String? ->
        val sNotNull: String = s!!
        println(sNotNull)
    }
    ignoreNulls("hello")
//    ignoreNulls(null) // !! 를 사용하는데 null 이면 NullPointerException 발생

    // let 함수
    println("\n===== let 함수")
    val sendEmailTo = { email: String? -> println("Sending email to $email") }
    val email: String? = "leaf@google.com"
    email?.let { sendEmailTo(it) }
    val email2: String? = null
    email2?.let { sendEmailTo(it) }
    email2.let { sendEmailTo(it) } // ?. 가 없으면 email2 가 null 이여도 let 부문 실행

    // 널이 될 수 있는 타입 확장
    println("\n===== 널이 될 수 있는 타입 확장")
    fun Person?.isNullOrEmpty(): Boolean = this == null || this.name.isEmpty()

    val person3 = Person("leaf", null)
    println(person3.isNullOrEmpty())
    val person4: Person? = null
    println(person4.isNullOrEmpty())


    // 타입 파라미터의 널 가능성
    println("\n===== 타입 파라미터의 널 가능성")
    fun <T> printHashCode(t: T) {
        println(t?.hashCode()) // "t"가 null이 될 수 있으므로 안전한 호출을 써야한다.
    }
    printHashCode(null)

    fun <T: Any> printHashCode2(t: T) { // 이제 T는 널이 될 수 없다.
        println(t.hashCode())
    }
//    printHashCode2(null) // 컴파일 에러
    printHashCode2(42)
}

class Company(val name: String?)
class Person(val name: String, val company: Company?) {
    override fun equals(other: Any?): Boolean {
        println("equals()")
        val obj = other as? Person ?: return false
        return obj.name == this.name
    }
}
