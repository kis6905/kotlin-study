package chapter08

import java.lang.StringBuilder
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.LockSupport

fun main() {
    println("고차 함수 안에서 흐름 제어")

    println("\n======== 람다 안의 return 문")
    val people = listOf(Person("leaf", 34), Person("bob", 29))
    fun lookForLeaf(people: List<Person>) {
        for (person in people) {
            if (person.name == "leaf") {
                println("Found!")
                return;
            }
        }
        println("Not Found!")
    }
    lookForLeaf(people)

    fun lookForLeaf2(people: List<Person>) {
        people.forEach {
            if (it.name == "leaf") {
                println("Found!")
                return; // forEach 는 inline 함수이므로 람다 밖의 함수가 return 된다.
                // 이렇게 바깥 함수가 return 되는 것을 non-local return 이라고 부른다.
            }
        }
        println("Not Found!")
    }
    lookForLeaf2(people)

    println("\n======== 람다로부터 반환: 레이블을 사용한 return")
    fun lookForLeaf3(people: List<Person>) {
        var leaf: Person? = null
        people.forEach label@{
            if (it.name == "leaf") {
                leaf = it
                return@label; // 레이블을 붙여주면 local return 이 된다.
            }
        }
        if (leaf == null) {
            println("Not Found!")
        } else {
            println("Found!")
        }
    }
    lookForLeaf3(people)

}
