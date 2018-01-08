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
class LoopBubbleSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        var exchanged = false
        var startIndex = 0

        while (startIndex < list.size - 1) {
            var i = list.size - 1
            while (i > startIndex) {
                if (list[i] < list[i - 1]) {
                    swap(list, i , i - 1)
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

}