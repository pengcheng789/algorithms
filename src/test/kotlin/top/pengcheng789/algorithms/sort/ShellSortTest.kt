package top.pengcheng789.algorithms.sort

import java.util.*

/**
 * CreateDate:2017-08-20
 *
 * @author pen
 */
fun main(args: Array<String>) {
    var i = 1000

    while (i <= 100000000) {
        val list = mutableListOf<Byte>()
        (1..i).map {
            list.add(getRandom(100.toByte(), 0))
        }

        val beginTime = Date()
        ShellSort.sort(list)
        val endTime = Date()
        println("Counts: $i, Total Time: ${endTime.time - beginTime.time} ms")
        i += i
    }
}

fun getRandom(max: Byte, min: Byte): Byte =
        ((Math.floor(Math.random() * (max - min))) + min).toByte()