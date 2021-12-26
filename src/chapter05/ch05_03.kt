package chapter05

fun main() {
    println("지연 계산(lazy) 컬렉션 연산")

    // 시퀀스를 사용하면 java8의 stream 과 동일하다.(lazy 연산)
    println(listOf(1, 2, 3, 4)
            .map {
                println("map, it: $it")
                it * it
            }
            .find { it >= 4 })

    println(listOf(1, 2, 3, 4).asSequence()
            .map {
                println("sequence map, it: $it")
                it * it
            }
            .find { it >= 4 })

    // java 에만 있는 parallelStream 을 사용해도 된다
    println(listOf(1, 2, 3, 4).parallelStream()
            .map {
                println("parallelStream map, it: $it")
                it * it
            }
            .filter { it >= 4 }
            .findFirst())

}
