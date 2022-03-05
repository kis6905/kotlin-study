package chapter07

import java.lang.IllegalArgumentException

fun main() {
    println("산술 연산자 오버로딩")

    println("\n======== 산술 연산자 오버로딩")
    val point1 = Point(1, 2)
    val point2 = point1 + Point(3, 3)
    println(point2)

    val point3 = point1 + 3
    println(point3)

    println("\n======== 복합 대입 연산자 오버로딩")
    var point4 = Point(2, 2) // 복합 대입 연산자를 사용하려면 var 선언 되어 변경 가능해야 한다.
    point4 += Point(1, 3)
    println(point4)

    println("\n======== 단항 연산자 오버로딩")
    val point5 = Point(4, 5)
    val point6 = -point5
    println(point6)

    var point7 = Point(4, 5)
    println(point7++)
    println(++point7)

}

data class Point(var x: Int, var y: Int) {
    // 연산자 함수 구현
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)

    // 복합 대입 연산자(+=, -= ...)는 plus 와 plusAssign 둘 중 1개의 함수만 있어야 한다.
//    operator fun plusAssign(other: Point) {
//        x += other.x
//        y += other.y
//    }

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

    operator fun inc(): Point {
        return this + Point(1, 1)
    }
}

// 확장 함수로도 가능하고, 오버로딩도 가능
operator fun Point.plus(number: Int): Point = Point(x + number, y + number)
