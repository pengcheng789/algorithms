package top.pengcheng789.algorithms.sort

/**
 * @author Cai Pengcheng
 * Create date: 18-1-11
 */
class RecursiveMergeSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        val result = ArrayList<T>()
        recursiveSort(list, result, 0, list.size - 1)
    }

    private fun recursiveSort(list: MutableList<T>, result: MutableList<T>,
                              start: Int, end: Int) {
        if (start >= end) { return }

        val mid = ( start + end ) shr 1
        recursiveSort(list, result, start, mid)
        recursiveSort(list, result, mid + 1, end)

        merge(list, result, start, end)
    }

    private fun merge(list: MutableList<T>, result: MutableList<T>,
                      start: Int, end: Int) {
        val mid = ( start + end ) shr 1

        var start1 = start
        var start2 = mid + 1
        var i = start
        while (start1 < mid + 1 && start2 < end + 1) {
            val smaller =
                if (list[start1] <= list[start2]) list[start1++] else list[start2++]
            result.add(i++, smaller)
        }
        while (start1 < mid + 1) { result.add(i++, list[start1++]) }
        while (start2 < end + 1) { result.add(i++, list[start2++]) }

        i = start
        while (i < end + 1) {
            list[i] = result[i]
            i++
        }
    }
}