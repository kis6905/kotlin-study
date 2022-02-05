package chapter09

fun main() {
    println("변성: 제네릭과 하위 타입")

}

open class Animal {
    fun feed() {
        println("feed()")
    }
}

class Herd<out T : Animal>(val animals: List<T>) { // out 키워드를 추가해 공변적이다
    val size: Int
        get() = animals.size

    operator fun get(i: Int) : T = animals[i]
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("cleanLitter()")
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats) // 캐스팅할 필요 없다
}
