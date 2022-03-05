package chapter02

import java.util.*

fun main() {
    println("코틀린의 예외 처리")

    val number = 99
    val percentage = if (number in 0..100) number else throw Exception("Invalid number")
    println("percentage: $percentage")

    println(checkAvailablePercentage(10))

    val number2 = 102
    val percentage2 = try {
        when (number2) {
            in 0..100 -> number2
            else -> throw Exception("Invalid number")
        }
    } catch (e: Exception) {
        null
    }

    println("percentage2: $percentage2")
}

fun checkAvailablePercentage(number: Int): Int? {
    try {
        if (number in 0..100)
            return number
        else
            throw Exception("Invalid number")
    } catch (e: Exception) {
        println("this is catch")
        return null
    } finally {
        println("this is finally")
    }
}
