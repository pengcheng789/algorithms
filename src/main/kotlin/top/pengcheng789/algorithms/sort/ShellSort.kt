package top.pengcheng789.algorithms.sort

/**
 * 希尔排序
 *
 * CreateDate:2017-08-20
 *
 * @author pen
 */
class ShellSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        val size = list.size

        var h = 1
        while (h < size / 3 ) h = 3 * h + 1

        while (h >= 1) {
            (h until size).forEach {
                var i = it
                while (i >= h) {
                    if (list[i] < list[i - h]) {
                        exchange(list, i, i - h)
                        i -= h
                    } else {
                        break
                    }
                }
            }
            h /= 3
        }
    }

    private fun exchange(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}