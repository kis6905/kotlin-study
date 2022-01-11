package chapter06

import java.lang.IllegalArgumentException

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

    println("\n===== Unit 타입: 코틀린의 void")
    fun f(): Unit {}
    println(f())
    println(NoResultProcessor().process())

    println("\n===== Nothing 타입")
    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }
//    fail("Error occurred")

    val person = Person("leaf", null)
    val company = person.company ?: fail("No Company")
    println(company.name)
}

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor: Processor<Unit> {
    override fun process() {
        // return 문 생략 가능. 코틀린이 알아서 return Unit 을 넣어준다.
    }
}

class ResultProcessor: Processor<String> {
    override fun process(): String { // return 타입이 없으면 안된다..
        return "process"
    }
}
