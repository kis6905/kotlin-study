package chapter08

import java.lang.StringBuilder
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.LockSupport

fun main() {
    println("인라인 함수: 람다의 부가 비용 없애기")

    println("\n========")
    foo {
        println(1)
        println(2)
    }

    println("\n======== 인라인 함수의 한계")
    bar({ println("this is inlined") }, { println("this is notInlined") })

    println("\n======== 컬렉션 연산 인라이닝")
    val people = listOf(Person("leaf", 34), Person("bob", 29))
    println(people.filter { it.age >= 30 }) // 컬렉션의 filter 는 inline 함수기 때문에 본문이 그대로 들어온다.
    println(people.filterWithoutInline { it.age >= 30 })
}

// inline 을 붙이면 이 함수를 호출하는 곳에 inline 함수의 본문이 그대로 들어간다.
inline fun foo(action: () -> Unit) {
    println("start foo()")
    val result = action()
    println("end foo()")
    return result
}

inline fun bar(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    println("invoke inlined()")
    inlined()

    println("invoke notInlined()")
    notInlined()
}

data class Person(val name: String, val age: Int)
fun List<Person>.filterWithoutInline(predicate: (Person) -> Boolean): List<Person> {
    var resultList: MutableList<Person> = mutableListOf();
    for (p in this) {
        if (predicate(p)) {
            resultList.add(p)
        }
    }
    return resultList
}
