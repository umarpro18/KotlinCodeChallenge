package com.igorwojda.integer.fibonacci.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println(fibonacci(10))
}
/*private fun fibonacci(n: Int): Int {

    if (n < 2) {
        return n
    }

    return fibonacci(n - 1) + fibonacci(n - 2)
}*/

private fun fibonacci(n: Int): Int {
    if (n < 2) {
        return n
    }

    var first = 0
    var second = 1
    var current = 0

    (2..n).forEach {
        println("it value --> $n")
        current = first + second
        first = second
        second = current
        println("it current value --> $current")
    }

    return current
}

private class Test {
    @Test
    fun `calculates correct fib value for 0`() {
        fibonacci(0) shouldBeEqualTo 0
    }

    @Test
    fun `calculates correct fib value for 1`() {
        fibonacci(1) shouldBeEqualTo 1
    }

    @Test
    fun `calculates correct fib value for 2`() {
        fibonacci(2) shouldBeEqualTo 1
    }

    @Test
    fun `calculates correct fib value for 3`() {
        fibonacci(3) shouldBeEqualTo 2
    }

    @Test
    fun `calculates correct fib value for 4`() {
        fibonacci(4) shouldBeEqualTo 3
    }

    @Test
    fun `calculates correct fib value for 39`() {
        fibonacci(39) shouldBeEqualTo 63245986
    }
}
