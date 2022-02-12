package chapter10

import kotlin.reflect.KFunction
import kotlin.reflect.full.*

fun main() {
    println("리플렉션")

    val person = Person("leaf", 34)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }
    kClass.declaredFunctions.forEach {
        it.call(person)
    }

    val kFunction = ::foo
    kFunction.call(42)

    val kProperty = person::counter
    kProperty.set(20)
    println(kProperty.get())

    val my1 = kProperty.findAnnotation<MyAnnotation>()
    println(my1?.name)
    println(my1?.defaultValue)

}

class Person(@property:MyAnnotation("name") val name: String, val age: Int) {
    fun printName() = println("name is $name")

    private var _counter: Int = 0

//    @MyAnnotation("counter", defaultValue = "0")
    @set:MyAnnotation("counter", defaultValue = "0")
    var counter: Int
        set (value) {
            println("counter set()")
            _counter = value
        }
        get () {
            println("counter get()")
            return _counter
        }
}

fun foo(x: Int) = println(x)
