package com.igorwojda.integer.fizzbuzz

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println(fizzBuzz(10))
}

private fun fizzBuzz(n: Int): List<String> {
    val fizzBuzzList = arrayListOf<String>()

    /*for (i in 1 until n + 1) {
        if (i % 3 == 0 && i % 5 == 0) {
            fizzBuzzList.add("FizzBuzz")
        } else if (i % 3 == 0) {
            fizzBuzzList.add("Fizz")
        } else if (i % 5 == 0) {
            fizzBuzzList.add("Buzz")
        } else {
            fizzBuzzList.add(i.toString())
        }
    }*/

    /*(1 until n +1).forEach {
        val item  = when {
            (it % 3 == 0 && it % 5 == 0) -> { "FizzBuzz" }
            (it % 3 == 0) -> { "Fizz" }
            (it % 5 == 0) -> { "Buzz" }
            else -> { it.toString() }
        }
        fizzBuzzList.add(item)
    }*/

    for (i in n   downTo 1) {
        val item = when {
            (i % 3 == 0 && i % 5 == 0) -> { "FizzBuzz" }
            (i % 3 == 0) -> { "Fizz" }
            (i % 5 == 0) -> { "Buzz" }
            else -> { i.toString() }
        }
        fizzBuzzList.add(item)
    }
    return fizzBuzzList.reversed()
}

private class Test {

    @Test
    fun `Calling fizzbuzz with "5" returns list with 5 items`() {
        fizzBuzz(5) shouldBeEqualTo listOf("1", "2", "Fizz", "4", "Buzz")
    }

    @Test
    fun `Calling fizzbuzz with 16 returns out the correct values`() {
        val list = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz",
            "7", "8", "Fizz", "Buzz", "11", "Fizz",
            "13", "14", "FizzBuzz", "16",
        )

        fizzBuzz(16) shouldBeEqualTo list
    }
}
