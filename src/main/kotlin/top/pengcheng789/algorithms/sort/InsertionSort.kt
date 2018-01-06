package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
class InsertionSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        (1 until list.size).forEach {
            var i = it
            while(i >= 1) {
                if (list[i] < list[i - 1]) {
                    exchange(list, i, i - 1)
                    i -= 1
                } else {
                    break
                }
            }
        }
    }

    private fun exchange(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}