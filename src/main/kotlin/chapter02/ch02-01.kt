package chapter02

fun main() {
    println("함수와 변수")
    println("hello, world!")
    println("max: ${max(1, 2)}")

    val str = "이것은 스트링"
    val num = 5
    println("str: $str, num: $num")
    // num = 6 // val 은 final 이기 때문에 재 할당 불가

    var num2 = 1
    num2 = 5
    println("num2: $num2")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b
