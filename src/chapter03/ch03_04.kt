package chapter03

fun main() {
    println("컬렉션 처리")

    val params = arrayOf(1, 2, 3)
    println(myListOf(*params)) // vararg로 선언된 파라미터는 넘기는 배열 앞에 *를 붙여야 한다.

    val map = mapOf(1.to("one"), 2 to("two"), 3 to "three")
    println(map)

    val (number, name) = 1 to "one"
    println("number: $number, name: $name")

    val (key, value) = "my" toMap 111 // toMap function 에 infix 가 없으면 괄호 없이 사용 불가
    println("key: $key, value: $value")
}

// vararg 는 java의 스프레드(...) 연산자와 동일
fun <T> myListOf(vararg values: T): List<T> {
    return listOf(*values)
}

infix fun String.toMap(value: Any): Pair<String, Any> = Pair(this, value)
