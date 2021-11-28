package chapter02

import java.lang.IllegalArgumentException

fun main() {
    println("enum과 when")

    println(eval(Sum(Sum(Num(1), Num(2)), Num(3))))

    println(evalWithLogging(Sum(Num(5), Num(6))))
}

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr {}

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("e is Num")
            e.value
        }
        is Sum -> {
            println("e is Sum")
            evalWithLogging(e.left) + evalWithLogging(e.right)
        }
        else -> throw IllegalArgumentException("Invalid e")
    }

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Invalid e")
    }
//    if (e is Num) {
//        e.value
//    } else if (e is Sum) {
//        eval(e.left) + eval(e.right)
//    } else {
//        throw IllegalArgumentException("Invalid e")
//    }
