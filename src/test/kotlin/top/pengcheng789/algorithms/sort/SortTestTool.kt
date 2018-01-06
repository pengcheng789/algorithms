package top.pengcheng789.algorithms.sort

import kotlin.collections.ArrayList

/**
 *
 * @author pen
 */
class SortTestTool {

    private val sortList: List<Sort<Int>>

    constructor(sortList: List<Sort<Int>>) {
        this.sortList = sortList
    }

    constructor(sort: Sort<Int>): this(listOf(sort))

    fun highMode() {
        val dataList = generateDataList()

        sortList.forEach { sort ->
            println()
            println("Current algorithms: ${sort.javaClass.simpleName}.")
            dataList.forEach {
                val data = it.toMutableList()
                val start = System.currentTimeMillis()
                sort.sort(data)
                val end = System.currentTimeMillis()
                println("Counts: ${it.size}, Total time: ${end - start}ms")
            }
            println()
        }
    }

    /**
     * Test the sort algorithms is Operating normally or not.
     */
    fun normalMode(dataNum: Int) {
        val originalList = mutableListOf<Int>()
        (1..dataNum).map {
            originalList.add(getRandom(1_000_000, 0))
        }
        println("Before sort: $originalList")

        sortList.forEach {
            val list = originalList.toMutableList()
            val start = System.currentTimeMillis()
            it.sort(list)
            val end = System.currentTimeMillis()

            println()
            println("Current algorithms: ${it.javaClass.simpleName}.")
            println("Total time: ${end - start}ms, $list")
        }

    }

    private fun generateDataList(): List<List<Int>> {
        println("Generating data list ...")

        val dataList = ArrayList<List<Int>>()
        var i = 1000

        while (i <= 128000) {
            val list = mutableListOf<Int>()
            (1..i).forEach {
                list.add(getRandom(1_000_000, 0))
            }

            dataList.add(list.toList())
            i = i shl 1
        }

        println("Generated data list.")

        return dataList
    }

    private fun getRandom(max: Int, min: Int): Int =
            ((Math.floor(Math.random() * (max - min))) + min).toInt()
}