package chapter03

import java.lang.IllegalArgumentException

fun main() {
    println("로컬 함수와 확장")

    saveUser(User(1L, "leaf", "goyang"))
    try {
        saveUser(User(1L, name = "leaf"))
    } catch (e: Exception) {
        println(e.message)
    }
    try {
        saveUser(User(1L, address = "goyang"))
    } catch (e: Exception) {
        println(e.message)
    }
}

class User(val id: Long, val name: String = "", val address: String = "")

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("userId: $id, empty $fieldName")
        }
    }
    validate(name, "name")
    validate(address, "address")
}

fun saveUser(user: User) {
//    if (user.name.isEmpty()) {
//        throw IllegalArgumentException("${user.id}: empty name")
//    }
//    if (user.address.isEmpty()) {
//        throw IllegalArgumentException("${user.id}: empty address")
//    }
    user.validateBeforeSave()

    // save
}
