package top.pengcheng789.algorithms.dataStruct

import top.pengcheng789.algorithms.dataStruct.bag.Bag
import top.pengcheng789.algorithms.dataStruct.bag.LinkedBag

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
fun main(args: Array<String>) {
    val bag: Bag<Int> = LinkedBag()

    (1..10).map { bag.add(it) }

    println("Element: $bag, Size: ${bag.size}")

}