package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
interface Sort<T: Comparable<T>> {

    fun sort(list: MutableList<T>)

    fun isSorted(list: MutableList<T>): Boolean {
        (1 until list.size).map {
            if (list[it] < list[it-1]) return false
        }
        return true
    }
}