package com.sample.umar.leetcodemediums.practice

/**
 * Requirements:
 * •	Use a stack
 * •	Push opening brackets: (, [, {
 *     •	For closing brackets, check if the top matches
 *     •	Return true if everything matches and stack becomes empty
 *     •	Return false for mismatch or early closing bracket
 */

/**
 * Algo:
 * Use stack principle,
 * iterate the given input string and store it as list of 'char' in a stack
 *      push for open parentheses
 *      When close parentheses appear
 *          if stack is empty return false
 *          check the top of stack for the opposite brace and if not a match then return false
 *          else pop back stack
 * After the loop finishes:
 *        - If the stack is empty → all brackets matched → return true else false
 *
 * Complexity:
 * - Time: O(n) for scanning each character once.
 * - Space: O(n) in worst case (all opening brackets).
 *
 */

fun main() {
    println(validParenthesesUseMap("((("))
}

fun validParentheses(inputStr: String): Boolean {
    val stackList = mutableListOf<Char>()
    inputStr.forEach {
        if (it == '(' || it == '[' || it == '{') {
            stackList.add(it)
        }
        if (it == ']' || it == ')' || it == '}') {
            if (stackList.isEmpty()) return false
            if (it == ']' && stackList.last() != '[') {
                return false
            } else if (it == ')' && stackList.last() != '(') {
                return false
            } else if (it == '}' && stackList.last() != '{') {
                return false
            } else {
                stackList.removeAt(stackList.size - 1)
            }
        }
    }
    return stackList.isEmpty()
}

fun validParenthesesAvoidIfElse(inputStr: String): Boolean {
    val stackList = mutableListOf<Char>()
    inputStr.forEach {
        when (it) {
            '(', '[', '{' -> {
                stackList.add(it)
            }

            else -> {
                if (stackList.isEmpty()) return false
                if (it == ']' && stackList.last() != '[') {
                    return false
                } else if (it == ')' && stackList.last() != '(') {
                    return false
                } else if (it == '}' && stackList.last() != '{') {
                    return false
                } else {
                    stackList.removeAt(stackList.size - 1)
                }
            }
        }
    }
    return stackList.isEmpty()
}

fun validParenthesesUseMap(inputStr: String): Boolean {
    val stackList = mutableListOf<Char>()
    val matchingBraces = mapOf<Char, Char>(')' to '(', '}' to '{', ']' to '[')

    inputStr.forEach {
        when (it) {
            '(', '[', '{' -> {
                stackList.add(it)
            }

            else -> {
                if (stackList.isEmpty() || stackList.last() != matchingBraces[it]) {
                    return false
                } else {
                    stackList.removeAt(stackList.size - 1)
                }
            }
        }
    }
    return stackList.isEmpty()
}