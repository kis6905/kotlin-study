package chapter04

fun main() {
    println("클래스 선언과 인스턴스 생성")

    println(MyUtils === MyUtils)
    println(MyUtils.isEmpty(""))

    val persons = listOf(Person("leaf"), Person("aabb"))
    println(persons.sortedWith(Person.NameComparator))

    A.bar()
}

interface StringUtils {
    fun isEmpty(value: String): Boolean
}

object MyUtils: StringUtils {
    override fun isEmpty(value: String): Boolean = value.isEmpty()
}

data class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
}

class A {
    companion object {
        fun bar() {
            println("companion object bar")

            val aa = 5
            val util = object: StringUtils { // function 안에서 object 선언 가능
                override fun isEmpty(value: String): Boolean {
                    println("a: $aa") // 바깥 변수 참조 가능
                    return value.isEmpty()
                }
            }
            foo(util)
        }

        private fun foo(util: StringUtils) {
            util.isEmpty("name")
        }
    }
}
