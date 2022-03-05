package chapter05

import java.lang.StringBuilder

fun main() {
    println("수신 객체 지정 람다: with와 apply")

    println(alphabetWith())
    println(alphabetApply())
}

fun alphabetWith(): String = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabetApply(): String = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()
