package chapter04

import java.lang.IllegalArgumentException

fun main() {
    println("클래스와 인터페이스")

    val button = Button()
    button.click()
    button.showOff()
    button.setFocus(true)
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable")
}

class Button: Clickable, Focusable {
    override fun click() {
        println("Button Click")
    }

    // 구현한 n개의 interface 에 똑같은 시그니처 default method 가 있으면 override 해야 한다.
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton: Clickable { // open 이 있어 다른 클래스가 상속할 수 있다.
    fun disable() {} // 기본적으로 final 이기 때문에 override 할 수 없다.
    open fun animate() {} // open 이 있기때문에 override 할 수 있다.
    override fun click() {}

    // final override fun click() {} // override 금지하기
}

abstract class Animated { // 추상클래스로써 인스턴스를 만들 수 없다.
    abstract fun animate() // 하위 클래스에서 반드시 override 해야한다.
}
