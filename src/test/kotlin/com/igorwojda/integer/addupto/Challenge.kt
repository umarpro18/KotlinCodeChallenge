package com.igorwojda.integer.addupto

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println("Total sum ${addUpTo(5)}")
}
private fun addUpTo(n: Int): Int {
    var totalSum = 0
    for(i in 1 until  n + 1) {
        totalSum += i
        println("loop: $i § $totalSum")
    }

    // test
    /*for(i in n downTo 1) {
        totalSum += i
        println("loop: $i § $totalSum")
    }*/
    return totalSum
}

private class Test {
    @Test
    fun `add up to 1`() {
        addUpTo(1) shouldBeEqualTo 1
    }

    @Test
    fun `add up to 3`() {
        addUpTo(3) shouldBeEqualTo 6
    }

    @Test
    fun `add up to 10`() {
        addUpTo(10) shouldBeEqualTo 55
    }
}
