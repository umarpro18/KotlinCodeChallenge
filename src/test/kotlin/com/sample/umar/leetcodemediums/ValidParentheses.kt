package com.sample.umar.leetcodemediums

fun main() {
    println(validParentheses("{[[[[]]]}()]"))
}

fun validParentheses(inputString: String): Boolean {
    // declare a stack with list of chars to feed in
    val stackCh: MutableList<Char> = mutableListOf<Char>()
    for (ch in inputString) {
        if (ch == '[' || ch == '(' || ch == '{') {
            stackCh.add(ch)
        }

        if (ch == ']' || ch == ')' || ch == '}') {
            if (stackCh.isEmpty()) return false
            val top = stackCh.last()
            if (ch == ']' && top != '[') {
                return false
            } else if (ch == ')' && top != '(') {
                return false
            } else if (ch == '}' && top != '{') {
                return false
            } else {
                stackCh.removeAt(stackCh.size - 1)
            }
        }
    }
    return stackCh.isEmpty()
}