package chapter06

fun main() {
    println("코틀린의 원시 타입")

    println("\n===== 널이 될 수 있는 원시 타입: Int?, Boolean? 등")
    val n1: Int = 5
    val n2: Int? = 5
    println("n1: $n1, n2: $n2")

    println("\n===== 숫자 변환")
    val i = 1
//    val l: Long = i // 컴파일 오류. 다른 타입으로 변환하지 않는다.

    fun foo(l: Long) = println(l)
    val b: Byte = 1
    val l: Long = b + 1L
    foo(42)

}
