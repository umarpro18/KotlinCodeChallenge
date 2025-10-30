package com.sample.umar


fun main() {
    LambdaPractise().pitStop()
    LambdaPractise().greet()

    println(LambdaPractise().multiply(4, 5))
    println(LambdaPractise().comparison(3, 3))
    println(LambdaPractise().listWithLambda)

    println("Pass lambda as param -->" + LambdaPractise().lambdaPractisePassing(3, 5, LambdaPractise().sum))
    println("Fold lambda -->" + LambdaPractise().foldSample)

    val returnedLambda = LambdaPractise().returnsLamdaTest("Happy")
    println("Return lambda from func -->" + returnedLambda("test"))


    val sum = LambdaPractise().applyOperation(3, 3) { a, b -> a + b }
    val multiply = LambdaPractise().applyOperation(3, 3) { a, b -> a * b }
    val subtract = LambdaPractise().applyOperation(4, 7) { a, b -> a - b }

    println("05Practise appOp --> $sum -- $multiply -- $subtract")

    val getOperationResult = LambdaPractise().getOperation("multiply")
    println("05Practise getOp --> " + getOperationResult(3, 7))

    val square: (Int) -> Int = { a -> a * a }
    val double: (Int) -> Int = { x -> x * 2 }
    val chainedLamResult = LambdaPractise().chainingLambdas(square, double)
    println("0505Practise chaining lambdas --> " + chainedLamResult(5))

    val tripleLambda: (Int) -> Int = { a -> a * 3 }
    val negateLambda: (Int) -> Int = { a -> a * -1 }
    val tripleAndNegate = LambdaPractise().tripleAndNegate(tripleLambda, negateLambda)
    println("0506Practise chaining lamdas --> " + tripleAndNegate(4))

    println("0506 filter even number -->" + LambdaPractise().filterEvenNumbers(listOf(1, 2, 4, 5, 6, 8, 9, 3, 10)))

    println(
        "0506 customised filtering -->" + LambdaPractise().customisedFiltering(
            listOf(
                1,
                2,
                4,
                5,
                6,
                8,
                9,
                3,
                10
            )
        ) { it > 3 })

    println(
        "0507 custom sort using lambda -->" + LambdaPractise().customSort(
            listOf<String>(
                "banana",
                "apple",
                "kiwi",
                "orange",
                "mango"
            )
        )
    )
    println(
        "0507 custom group by using lambda -->" + LambdaPractise().groupByWords(
            listOf<String>(
                "banana",
                "badam",
                "apple",
                "kiwi",
                "orange",
                "mango"
            )
        )
    )

    val pairs = listOf(Pair("umar", 3), Pair("azza", 4), Pair("usaid", 6))

    println("0507 paired generics " + LambdaPractise().transformMultiGeneric(pairs) { a, b -> a + b })

    val maps = mapOf("A1" to 1, "U1" to 2, "U" to 3, "A" to 4)

    println("0508 iterate maps: " + LambdaPractise().transformMapOfCollection(maps) { a, b -> a + b })


    "Umar".customExtensionPrac(3) { a, b -> println("0517 extension func practise:$a, $b") }

    10.000.customExtensionPrac(5) { a, b -> println("0517 extension func practise:$a, $b") }

    "LambdaWithReceiverTest".customExtensionLambdaWithReceiver(4) { println("0517 receiver func practise: $it and $this") }

}

// A class will always a property or a methods

// Lambda basically means { param's -> logic or expression }
class LambdaPractise {
    private val testLamb: () -> Double = { 0.0 }
    val pitStop: () -> Unit = { println("*****New lambda*****") }
    val greet: () -> Unit = { println("Hello!") }
    val sum: (Int, Int) -> Int = { a, b -> a + b }
    val sumOne = { a: Int, b: Int, c: Int -> a + b + c }

    val lambdaWithReceiver: String.() -> Unit = { "test" }

    val multiply: (Int, Int) -> Int = { a, b -> a * b }

    val comparison: (Int, Int) -> String =
        { a, b ->
            when {
                (a > b) -> "A value is greater"
                (a < b) -> "B value is greater"
                else -> "Both are equal"
            }
        }


    private val simpleList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listWithLambda = simpleList.filter { it % 2 == 0 }

    val simpleDefine: () -> String = { "test" }
    fun lambdaPractisePassing(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    private val numbsList = listOf(1, 2, 3, 4, 5, 6)
    val foldSample = numbsList.fold(0) { acc, num -> acc + num }

    fun returnsLamdaTest(a: String): (String) -> String {
        return { param -> "Hello, Usaid Umar $param and $a" }
    }


    fun applyOperation(a: Int, b: Int, operationL: (Int, Int) -> Int): Int = operationL(a, b)

    fun getOperation(operation: String): (Int, Int) -> Int = when (operation) {
        "add" -> { a, b -> a + b }
        "multiply" -> { a, b -> a * b }
        else -> { a, b -> a - b }
    }

    fun <T> chainingLambdas(square: (T) -> T, double: (T) -> T): (T) -> T {
        return { it -> square(double(it)) }
    }

    fun <T> tripleAndNegate(triple: (T) -> (T), negate: (T) -> T): (T) -> T {
        return { it -> negate(triple(it)) }
    }

    fun filterEvenNumbers(listA: List<Int>): List<Int> {
        return listA.filter { it % 2 == 0 }
    }

    fun customisedFiltering(listA: List<Int>, condition: (Int) -> Boolean): List<Int> {
        return listA.filter { condition(it) }
    }

    fun customSort(str: List<String>): List<String> {
        return str.sortedBy { it.length }
    }

    fun groupByWords(strList: List<String>): Map<Char, List<String>> {
        return strList.groupBy { it.first() }.mapValues { it.value.sorted() }
            .toSortedMap()
    }

    fun <A, B, R> transformMultiGeneric(pairs: List<Pair<A, B>>, transform: (A, B) -> R): List<R> {
        return pairs.map { (a, b) -> transform(a, b) }
    }

    // Need more practise on generics and method params writings esp trying with map entries...

    fun <A, B, R> transformMapOfCollection(mapList: Map<A, B>, transform: (A, B) -> R): List<R> {
        //val result = mapList.map { (a, b) -> transform(a, b) }
        val resultList = mutableListOf<R>()
        mapList.forEach { (key, value) ->
            resultList.add(transform(key, value))
        }
        return resultList
    }
}

// Extension func with only String
fun String.customExtensionPrac(times: Int, block: (Int, String) -> Unit) {
    repeat(times) { i ->
        block(i, this)
    }
}

// Extension func with different types
fun <T> T.customExtensionPrac(times: Int, block: (Int, T) -> Unit) {
    repeat(times) { i ->
        block(i, this)
    }
    for (i in 0 until 10) {
        block(i, this)
    }
}

// Extension fun with lambda with receiver
fun <T> T.customExtensionLambdaWithReceiver(times: Int, getData: T.(Int) -> Unit) {
    repeat(times) { i ->
        this.getData(i)
    }
}