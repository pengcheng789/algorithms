package top.pengcheng789.algorithms.sort

/**
 * 希尔排序
 *
 * CreateDate:2017-08-20
 *
 * @author pen
 */
object ShellSort {

    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        val size = list.size

        var h = 1
        while (h < size / 3 ) h = 3 * h + 1

        while (h >= 1) {
            (h until size).map {
                (it downTo h step h).map {
                    if (list[it] < list[it-h]) exchange(list, it, it-h)
                }
            }
            h /= 3
        }
    }

    fun <T: Comparable<T>> isSorted(list: MutableList<T>): Boolean {
        (1 until list.size).map {
            if (list[it] < list[it-1]) return false
        }
        return true
    }

    private fun <T> exchange(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}