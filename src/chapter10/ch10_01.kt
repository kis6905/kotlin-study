package chapter10

import kotlin.reflect.KClass

fun main() {
    println("애노테이션 선언과 적용")

    @Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
    fun removeAt(index: Int) {}

    @MyAnnotation("aa", "bb")
    fun myFun() {}

    @MyAnnotation1(Foo::class)
    fun myFun1() {}

    @MyAnnotation(defaultValue = "value")
    fun myFun2() {}

}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_SETTER)
annotation class MyAnnotation(val name: String = "", val defaultValue: String = "")

// 애노테이션 파라미터로 제네릭 클래스 받기
annotation class MyAnnotation1(val name: KClass<out MyInterface<*>>)

interface MyInterface<T>

class Foo<T>: MyInterface<T> {
    // 사용지점대상 선언으로 애노테이션을 붙일 요소를 정할 수 있음
    @property:MyAnnotation("my_name")
    var name: String? = null

    @set:MyAnnotation("my_age")
    var age: Int? = null
}


