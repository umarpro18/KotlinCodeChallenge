package com.igorwojda.integer.stepsgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generateSteps(n: Int): List<String> {
    val result: MutableList<String> = mutableListOf<String>()
    //val str = "#"
    //val spacer = " "
    /*for (i in 1 .. n) {
        result.add((str.repeat(i)) + spacer.repeat(n - i))
    }
    println(result)*/
    // Without repeat, we need a total of three loops: 1. exact n times (rows), 2. for no. of "#", 3. for space (n - i)

    for (i in 1 .. n) {
        var str = ""
        var storeSpacer = ""
        val spacer = " "
        for (j in 1 .. i) {
            str += "#"
            (j .. (n - i)).forEach {
                storeSpacer += spacer
            }
        }
        result.add(str + storeSpacer)
    }
    println(result)
    return result
}

private class Test {
    @Test
    fun `steps n = 1`() {
        val actual = generateSteps(1)
        actual.size shouldBeEqualTo 1
        actual[0] shouldBeEqualTo "#"
    }

    @Test
    fun `steps n = 2`() {
        val actual = generateSteps(2)
        actual.size shouldBeEqualTo 2
        actual[0] shouldBeEqualTo "# "
        actual[1] shouldBeEqualTo "##"
    }

    @Test
    fun `steps n = 3`() {
        val actual = generateSteps(3)
        actual.size shouldBeEqualTo 3
        actual[0] shouldBeEqualTo "#  "
        actual[1] shouldBeEqualTo "## "
        actual[2] shouldBeEqualTo "###"
    }
}
