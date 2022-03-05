package chapter07

fun main() {
    println("구조 분해 선언과 component 함수")

    val p = Point(10, 20)
    val (x, y) = p
    println("$x, $y")

    val list = listOf("가", "나", "다", "라", "마", "바")
    val (a, b, c, d, e) = list // 컬렉션 구조분해는 앞에서 5개까지만 제공
//    val (a, b, c, d, e, f) = list // 5개 이상을 구조분해 하면 컴파일 에러
    println("$a, $b, $c, $d, $e")

    val map = mapOf("Leaf" to "고양시", "Abc" to "서울시")
    for ((key, value) in map) {
        println("$key, $value")
    }
}
