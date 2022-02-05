package chapter09

fun main() {
    println("타입 소거와 실체화 타입 파라미터")

    println("\n======== 타입 검사와 캐스트")
    fun printlnSum(c: Collection<*>) { // 스타 프로젝션을 사용하면 값이 List라는 사실을 확인할 수 있다.
        val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
        println(intList.sum())
    }
    printlnSum(listOf(1, 2, 3))
//    printlnSum(listOf("a", "b", "c")) // List<Int>로 캐스팅은 되지만 sum()에서 오류 발생

    println("\n======== 실체화한 타입 파라미터를 사용한 함수 선언")
    println(isA<String>("abc"))
    println(isA<String>(123))

}

// 타입 소거가 되면 런타임 시 알수 없지만 inline + reified 를 사용하면 런타임 시 타입 검사를 할 수 있다.
inline fun <reified T> isA(value: Any) = value is T
