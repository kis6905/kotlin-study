package chapter07

import java.lang.IndexOutOfBoundsException
import java.time.LocalDate

fun main() {
    println("컬렉션과 범위에 대해 쓸 수 있는 관례")

    println("\n======== 인덱스로 원소에 접근: get과 set")
    val point = Point(3, 7)
    println("x: ${point[0]}, y: ${point[1]}")

    point[0] = 5
    println("$point")

    println("\n======== in 관례")
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)
    println(Point(5, 5) in rect)

    println("\n======== rangTo 관례")
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)

    println("\n======== iterator 관례")
    val newYear = LocalDate.ofYearDay(2022, 1)
    val daysOff = newYear.minusDays(3)..newYear
    for (dayOff in daysOff) { println(dayOff) }
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun Point.set(index: Int, value: Int) {
    when (index) {
        0 -> this.x = value
        1 -> this.y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// in 관례
data class Rectangle(val upperLeft: Point, val lowerRight: Point)
operator fun Rectangle.contains(p: Point): Boolean {
    println("contains()... p: $p")
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}

// iterator 관례
// rangeTo 함수가 ClosedRange 인스턴스를 반환하기 때문에 ClosedRange 의 확장 함수로 작성
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object: Iterator<LocalDate> {
        var current = start
        override fun hasNext() = current <= endInclusive
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }
