package chapter03

fun main() {
    println("확장 함수와 확장 프로퍼티")

    println("Kotlin".lastChar())

    val list = listOf(1, 2, 3)
    println(list.myJoinToString(";"))

    val strings = listOf("1", "2", "3")
    println(strings.join(";"))

    val button: View = Button()
    button.click()
    button.showOff()

    println("Kotlin".lastCharacter)
}

fun String.lastChar(): Char = get(length - 1)

fun <T> Collection<T>.myJoinToString(separator: String, prefix: String = "(", postfix: String = ")"): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String, prefix: String = "(", postfix: String = ")"): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() {
    println("I'm a view")
}

fun Button.showOff() {
    println("I'm a button")
}

val String.lastCharacter: Char
    get() {
        println("lastCharacter property get()")
        return get(length - 1)
    }
