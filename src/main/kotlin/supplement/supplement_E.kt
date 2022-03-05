package supplement

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)
fun log(msg: String) = println("${now()}:${Thread.currentThread()}: ${msg}")

fun main() {
//    test1()
//    test2()
//    test3()
//    sumAll()
//    test4()
    suspendExample()
}

fun test1() {
    log("main() started")

    launchInGlobalScope()

    log("coroutine executed")

    /*
     * GlobalScope 는 메인 스레드가 실행중인 동안만 코루틴의 동작을 보장해주기 때문에
     * Thread.sleep()이 없으면 코루틴은 동작하지 않느다.
     */
    Thread.sleep(1000)
    log("main() terminated")
}

fun test2() {
    log("main() started")
    // 코루틴 실행 스레드도 main 스레드 이다.
    runBlockingExample()
    log("coroutine executed")
    log("main() terminated")
}

fun test3() {
    log("main() started")
    yieldExample()
    log("coroutine executed")
    log("main() terminated")
}

fun test4() {
    runBlocking {
        launch { // 부모 컨텐스트를 사용(이 경우 main)
            log("main runBlocking")
        }
        launch(Dispatchers.Unconfined) { // 특정 스레드에 종속되지 않음. 메인 스레드 사용
            log("Unconfined")
        }
        launch(Dispatchers.Default) { // 기본 디스패처를 사용
            log("Default")
        }
        launch(newSingleThreadContext("MyOwnThread")) { // 새 스레드를 사용
            log("newSingleThreadContext")
        }
    }
}

fun launchInGlobalScope() {
    GlobalScope.launch {
        log("coroutine started.")
    }
}

fun runBlockingExample() {
    runBlocking { // 현재 스레드를 block 시킴
        launch {
            log("coroutine started with runBlocking.")
        }
    }
}

fun yieldExample() {
    runBlocking {
        launch {
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }
        log("after first launch")
        launch {
            log("2")
            delay(1000)
            log("4")
            delay(1000)
            log("6")
        }
        log("after second launch")
    }
}

fun sumAll() {
    runBlocking {
        val d1 = async { log("d1()"); delay(1000); 1 }
        log("after async(d1)")
        val d2 = async { log("d2()"); delay(2000); 2 }
        log("after async(d2)")
        val d3 = async { log("d3()"); delay(3000); 3 }
        log("after async(d3)")

        log("1+2+3 = ${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}

suspend fun yieldThreeTimes() {
    log("1")
    delay(1000)
    yield()
    log("2")
    delay(1000)
    yield()
    log("3")
    delay(1000)
    yield()
    log("4")
}

fun suspendExample() {
    runBlocking {
        launch {
            yieldThreeTimes()
        }
    }
}
