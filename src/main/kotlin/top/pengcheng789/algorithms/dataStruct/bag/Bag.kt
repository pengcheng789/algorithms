package top.pengcheng789.algorithms.dataStruct.bag

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
abstract class Bag<T> {

    var size = 0
        protected set

    abstract fun add(value: T)

    abstract fun getByIndex(index: Int): T

    abstract fun clean()

    fun isEmpty(): Boolean { return size == 0 }

    override fun toString(): String {
        var s = "["
        if (size == 0)
            s += ","
        else (0..(size - 1)).map { s += getByIndex(it).toString() + "," }
        return s.substring(0..(s.length-2)) + "]"
    }
}