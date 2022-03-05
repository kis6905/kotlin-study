package supplement

import javax.naming.NoInitialContextException

fun main() {

    // 람다 파라미터에서도 구조 분해 사용
    val nums = listOf(1, 2, 3)
    val names = listOf("one", "two", "three")
    (nums zip names).forEach{ (num, name) -> println("${num} = ${name}") }

    // 밑줄(_)로 파라미터 무시
    fun applyYMD(v: YMD, f: YMDFUN) = f(v)
    val now = YMD(2022, 2, 26)
    val samil = YMD(1919, 3, 1)
    val (yyyy, _, dd) = samil
    println("${yyyy}, ${dd}")
    applyYMD(YMD(2022, 1, 1)) { (yyyy, _, dd) -> println("${yyyy}, ${dd}") }

    // minOf, maxOf
    val longest = maxOf(listOf(1, 2), listOf(10), compareBy { it.size })
    println(longest) // [1, 2]

    // 람다를 사용한 리스트 초기화
    val evens = List(10) { 2 * it }
    println(evens) // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

    // 지연 추기화 개선, ::name.isInitialized
    val person = Person()
    println(person.getMyName())
    person.name = "leaf"
    println(person.getMyName())

    // 컬렉션
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    val chunkedList = list.chunked(3)
    println(chunkedList) // [[1, 2, 3], [4, 5, 6], [7]]

    val windowedList = list.windowed(3)
    println(windowedList) // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7]]


}

data class YMD(val year: Int, val month: Int, val day: Int)
typealias YMDFUN = (YMD) -> Unit

class Person() {
    lateinit var name: String

    fun getMyName(): String {
        return if (::name.isInitialized) {
            name
        } else {
            "Unknown"
        }
    }
}
