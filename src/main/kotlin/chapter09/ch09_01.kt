package chapter09

fun main() {
    println("제네릭 타입 파라미터")

    println("\n======== 타입 파라미터 제약")
    fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable { // 제약을 여러개도 가능
        if (!seq.endsWith('.')) {
            seq.append('.')
        }
    }

    fun <T> printlnNullable(param: T) {
        println(param)
    }
    printlnNullable(null) // 기본적으로 T는 null 을 허용

    fun <T : Any> printlnNonNull(param: T) {
        println(param)
    }
//    printlnNonNull(null) // <T: Any>로 선언하면 null 허용 안함

}
