package chapter06

import java.lang.IllegalArgumentException

fun main() {
    println("컬렉션과 배열")

    println("\n===== 널 가능성과 컬렉션")
    val list1: List<Int?> = listOf(1, 2, 3, null)
//    val list2: List<Int> = listOf(1, 2, 3, null) // 컴파일 에러

    val validItems = list1.filterNotNull()
    println(validItems)

    val list3: List<Int>? = null
//    val list4: List<Int> = null // 컴파일 에러

    println("\n===== 읽기 전용과 변경 가능한 컬렉션")
    val list5: List<Int> = listOf(1, 2, 3)
//    list5.add() // add 함수 자체가 없음

    val list6: MutableList<Int> = mutableListOf(1, 2 ,3)
    list6.add(4)

    val list7: List<Int> = mutableListOf(1, 2, 3) // 타입은 불변이지만 구현체는 변경 가능한 컬렉션도 가능

    setOf<String>("1", "2")


}
