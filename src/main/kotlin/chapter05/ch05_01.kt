package chapter05

fun main() {
    println("람다 식과 멤버 참조")

    val people = listOf(Person("leaf", 33), Person("tree", 25))
    
    println(people.maxByOrNull({ p: Person -> p.age })) // 람다의 기본 형식
    println(people.maxByOrNull({ p -> p.age })) // 타입 생략 가능
    println(people.maxByOrNull { p -> p.age }) // 함수의 인자가 람다식 하나인 경우 중괄호 생략 가능 
    println(people.maxByOrNull { it.age }) // 람다의 파라미터 디폴트 이름인 it 으로 사용 가능
}

data class Person(val name: String, val age: Int)
