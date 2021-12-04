package chapter03

fun main() {
    println("함수를 호출하기 쉽게 만들기")

    val list = listOf(1, 2, 3)
    println(joinToString(collection = list, separator = ";", prefix = "[", postfix = "]"))
    println(joinToString(collection = list, separator = ";", prefix = "{")) // 디폴트 파라미터가 있으면 생략 가능
    println(joinToString(collection = list, prefix = "(", separator = ";")) // 인자 이름을 붙이면 순서 상관 없음

    println(readOperatedCount())
}

//fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String = "(", postfix: String = ")"): String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in collection.withIndex()) {
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//    result.append(postfix)
//    return result.toString()
//}
