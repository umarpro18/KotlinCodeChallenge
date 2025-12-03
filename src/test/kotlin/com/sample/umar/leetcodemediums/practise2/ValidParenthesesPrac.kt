package com.sample.umar.leetcodemediums.practise2

fun main() {
    println(isValidParentheses("[[[]]])"))
}

/**
 * Algo:
 * Iterate the input string
 * Declare a mutable list to perform (stack principle)
 * For every open braces push it
 * For every close braces check,
 *        if stack is empty return false
 *        check the top of stack and if matches pop it else return false
 * Finally return true if stack is empty  (means all are valid)
 *
 * It will be o(n) and o(n)
 */

fun isValidParentheses(inputStr: String): Boolean {
    val resultList = mutableListOf<Char>()
    // condition check map
    val conditionCheckMap = mapOf<Char, Char>(')' to '(', '}' to '{', ']' to '[')
    inputStr.forEach {
        when (it) {
            '[', '(', '{' -> {
                resultList.add(it)
            }

            else -> {
                if (resultList.isEmpty()) return false
                if (resultList.last() == conditionCheckMap[it]) {
                    resultList.removeAt(resultList.size - 1)
                } else {
                    return false
                }
            }
        }
    }
    return resultList.isEmpty()
}