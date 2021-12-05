package chapter04

fun main() {
    println("클래스와 인터페이스")

    Outer("leaf").printName()
}

class Outer(val name: String) {

    inner class Inner { // inner 를 붙여줘야 바깥 클래스를 참조할 수 있다
        fun getOuterReference() = println("Inner, ${this@Outer.name}")
    }

    fun printName() {
        Inner().getOuterReference()
    }
}

sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
//    class Square(val value: Int): Expr() // 이렇게 하위클래스가 추가되면 when 에서 따로 처리를 해줘야 한다.
}



fun eval(e: Expr): Int =
    when(e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.left) + eval(e.right)
    }
