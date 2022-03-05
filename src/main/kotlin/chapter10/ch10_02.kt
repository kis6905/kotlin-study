package chapter10

fun main() {
    println("리플렉션")

    val person = Person("leaf", 34)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.members.forEach { println(it.name) }
//    kClass.memberProperties.forEach { println(it.name) }
//    kClass.declaredFunctions.forEach {
//        it.call(person)
//    }

    println("===============")

    val kFunction = ::foo
    kFunction.call(42)

    val kProperty = person::counter
    kProperty.set(20)
    println(kProperty.get())

    val annotations = kProperty.annotations
    annotations
        .filter { it.annotationClass.simpleName == MyAnnotation::class.java.simpleName }
        .map { it as MyAnnotation }
        .forEach { println(it.name) }
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
