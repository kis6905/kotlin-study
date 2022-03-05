package chapter02

import java.util.*

fun main() {
    println("while과 for 루프")

    val oneToTen = 1..10
    for (i in oneToTen) {
        println(i)
    }

    val tenToOne = 10 downTo 1
    for (i in tenToOne step 2) {
        println(i)
    }

//    val map: Map<Char, String> = HashMap() // 이건 왜 안되지??
    val map = HashMap<Char, String>()
    for (c in 'a'..'d') {
        map[c] = Integer.toBinaryString(c.toInt())
    }
    for ((char, binaryString) in map) {
        println("$char = $binaryString")
    }

    println(containsInAtoZ('c'))
    println(containsInAtoZ('0'))
}

fun containsInAtoZ(c: Char): Boolean =
    when (c) {
        in 'a'..'z', in 'A'..'Z' -> true
        else -> false
    }
