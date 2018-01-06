package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
class BubbleSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        var exchanged = false
        var startIndex = 0

        while (startIndex < list.size - 1) {
            var i = list.size - 1
            while (i > startIndex) {
                if (list[i] < list[i - 1]) {
                    exchange(list, i , i - 1)
                    exchanged = true
                }

                i--
            }

            if (exchanged) {
                startIndex++
            } else {
                return
            }
        }
    }

    private fun exchange(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}