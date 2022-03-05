package chapter05

fun main() {
    println("컬렉션 함수형 API")

    println("\n=== map, filter ===")
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it and 1 == 0 }) // java의 bit 연산자인 &는 and 함수로 대체 됨

    val people = listOf(Person("Leaf", 20), Person("Hong", 25))
    println(people.filter { it.age > 24 })

    println(people.map{ it.name })
    println(people.map(Person::name)) // 멤버참조로도 가능

    println(people.filter { it.age > 24 }.map(Person::name))

    // 2중 loop 는 제거
    val max = people.filter { it.age == people.maxByOrNull(Person::age)!!.age } // 2중 loop
    println("max: $max")

    val maxAge = people.maxByOrNull(Person::age)!!.age
    val maxPerson = people.filter { it.age == maxAge } // 2중 loop 개선
    println("maxPerson: $maxPerson")

    // map 에도 filter, map 함수가 있다.
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase() })
    println(numbers.filterKeys { it == 0 })

    println("\n=== any, all, count ===")
    println("any: ${people.any { it.age > 24 }}")
    println("all: ${people.all { it.age > 24 }}")

    println("count: ${people.count { it.age > 24 }}")
    println(people.filter { it.age > 24 }.size) // 이렇게 쓰면 중간 컬렉션이 생긴다. 따라서 count 가 훨씬 더 효율적이다.

    // group by
    val people2 = listOf(Person("Leaf", 20), Person("Hong", 25), Person("Kim", 25))
    println("\n=== group by ===")
    println(people2.groupBy { it.age })

    // flatMap, flatten
    val books = listOf(Book("코틀린 인 액션", listOf("Kim", "Lee")), Book("잘살자", listOf("Kwon", "Lee")))
    println("\n=== flatMap, flatten ===")
    println(books.flatMap { it.authors })
    println(books.flatMap { it.authors }.toSet()) // Set 으로 변환해 중복 제거

}

data class Book(val title: String, val authors: List<String>)
