package chapter04

fun main() {
    println("데이터 클래스와 클래스 위임")

    val client1 = Client("leaf", 1)
    val client2 = Client("leaf", 1)

    println(client1)
    println(client1 == client2)

    val clientWithData1 = ClientWithData("leaf", 1)
    val clientWithData2 = ClientWithData("leaf", 1)

    println(clientWithData1)
    println(clientWithData1 == clientWithData2) // 코틀린은 == 가 java 의 equals 랑 같다.
    println(clientWithData1 === clientWithData2) // 참조 비교를 하려면 === 를 사용해야 한다.
    val clientWithData3 = clientWithData2.copy(postalCode = 5)
    println(clientWithData3)

    val foo: MyInterface = Foo()
    val bar: MyInterface = Bar(foo)
    bar.test()
}

class Client(val name: String, val postalCode: Int)

// data 를 달아주면 toString, equals, hasCode 를 생성해준다.
data class ClientWithData(val name: String, val postalCode: Int)

interface MyInterface {
    fun test()
}

class Foo: MyInterface {
    override fun test() {
        println("Foo test")
    }
}

class Bar(
    val foo: MyInterface
): MyInterface by foo
