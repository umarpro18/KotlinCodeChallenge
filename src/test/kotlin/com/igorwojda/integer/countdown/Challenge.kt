package com.igorwojda.integer.countdown

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main(){
    val returnedList = countDown(5)
    returnedList.forEach { println(it) }
}
private fun countDown(n: Int): List<Int> {
    val listCountDown = arrayListOf<Int>()
    /*for(i in n downTo  0) {
           listCountDown.add(i)
    }*/

    return (n downTo 0).toList()
    //return listCountDown
}

private class Test {
    @Test
    fun `count down 0`() {
        countDown(0) shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count down 1`() {
        countDown(1) shouldBeEqualTo listOf(1, 0)
    }

    @Test
    fun `count down 5`() {
        countDown(5) shouldBeEqualTo listOf(5, 4, 3, 2, 1, 0)
    }
}
