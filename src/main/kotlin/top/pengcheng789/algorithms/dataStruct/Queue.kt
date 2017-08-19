package top.pengcheng789.algorithms.dataStruct

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
abstract class Queue<T> {

    var size = 0
        protected set

    abstract fun enQueue(value: T)

    abstract fun deQueue(): T

    abstract fun getByIndex(index: Int): T

    abstract fun clean()

    override fun toString(): String {
        var s = "["
        if (size == 0) s += ","
        else (0..(size - 1)).map { s += getByIndex(it).toString() + "," }
        return s.substring(0..(s.length-2)) + "]"
    }
}