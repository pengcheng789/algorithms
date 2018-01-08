/*
 * copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
*/
package top.pengcheng789.algorithms.sort

/**
 *
 * @author Cai Pengcheng
 */
class RecursiveQuickSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        recursiveSort(list, 0, list.size - 1)
    }

    private fun partition(list: MutableList<T>, left: Int,
                          right: Int, pivotIndex: Int): Int {
        val pivotValue = list[pivotIndex]
        swap(list, right, pivotIndex)
        var storeIndex = left

        var i = left
        while (i < right) {
            if (list[i] <= pivotValue) {
                swap(list, i, storeIndex)
                storeIndex++
            }
            i++
        }

        swap(list, storeIndex, right)
        return storeIndex
    }

    private fun recursiveSort(list: MutableList<T>, left: Int, right: Int) {
        if (left < right) {
            val pivotIndex = (left + right) / 2
            val pivotNewIndex = partition(list, left, right, pivotIndex)
            recursiveSort(list, left, pivotNewIndex - 1)
            recursiveSort(list, pivotNewIndex + 1, right)
        }
    }
}