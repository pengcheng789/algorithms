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
 * 希尔排序
 *
 * CreateDate:2017-08-20
 *
 * @author pen
 */
class LoopShellSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        val size = list.size

        var h = 1
        while (h < size / 3 ) h = 3 * h + 1

        while (h >= 1) {
            (h until size).forEach {
                var i = it
                while (i >= h) {
                    if (list[i] < list[i - h]) {
                        swap(list, i, i - h)
                        i -= h
                    } else {
                        break
                    }
                }
            }
            h /= 3
        }
    }
}