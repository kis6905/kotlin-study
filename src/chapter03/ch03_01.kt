package chapter03

fun main() {
    println("코틀린에서 컬렉션 만들기")

    val list = arrayListOf(1, 2, 3)
    val map = hashMapOf(1 to "one", 2 to "two") // to는 키워드가 아니라 일반 함수다

    list.add(4)

    println(list)
    println(map)

    val strings = listOf("first", "second") // immutable
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.max())
}
