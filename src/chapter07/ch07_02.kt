package chapter07

fun main() {
    println("비교 연산자 오버로딩")

    println("\n======== 순서 연산자: compareTo")
    val list = listOf(Foo(5), Foo(2), Foo(9))
    println(list)
    val list2 = list.sorted()
    println(list2)

}

data class Foo(val value: Int): Comparable<Foo> {
    override fun compareTo(other: Foo): Int {
        println("compareTo(), this.value: $this.value, other.value: $other.value")
        return compareValuesBy(this, other, Foo::value)
    }
}
