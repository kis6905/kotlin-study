package chapter02

fun main() {
    println("클래스와 프로퍼티")

    val person = Person("leaf", 33)
    println("name: ${person.name}, age: ${person.age}")
}

class Person(
    val name: String,
    var age: Int
)
