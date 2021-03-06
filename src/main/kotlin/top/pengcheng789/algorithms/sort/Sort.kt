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

    fun swap(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}