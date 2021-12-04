@file: JvmName("StringFunctions")

package chapter03

var operatedCount = 0

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String = "(", postfix: String = ")"): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    operatedCount++
    return result.toString()
}

fun readOperatedCount() = operatedCount
