package chapter08

import java.lang.StringBuilder

fun main() {
    println("고차 함수")

    println("\n======== 함수타입")
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println(42) }
    println(sum(1, 2))
    action()

    var canReturnNull: (Int, Int) -> Int? = { x, y -> null } // 함수의 반환이 nullable
    val nullableResult: Int? = canReturnNull(1, 2)

    var funOrNull: ((Int, Int) -> Int)? = null // 함수 타입 자체가 nullable

    println("\n======== 인자로 받은 함수 호출")
    fun twoAndThree(operation: (Int, Int) -> Int) {
        val result = operation(2, 3)
        println(result)
    }
    twoAndThree { x, y -> x + y }
    twoAndThree { x, y -> x * y }

    println("ab2c4d41".filter { it in 'a'..'z' })

    println("\n======== 널이 될 수 있는 함수 타입 파라미터")
    fun foo(callback: (() -> Unit)?) {
//        callback() // 불가능
        if (callback != null) {
            callback() // null 체크 후 호출 가능
        }
        callback?.invoke() // 안전한 호출을 사용하는 방식도 가능
    }
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}
