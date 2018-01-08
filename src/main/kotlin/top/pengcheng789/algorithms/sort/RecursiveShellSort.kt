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
class RecursiveShellSort<T: Comparable<T>>: Sort<T> {

    override fun sort(list: MutableList<T>) {
        var step = 1
        while (step < list.size / 3 ) step = 3 * step + 1

        decreaseStep(list, step)
    }

    private tailrec fun insertToOrderArea(list: MutableList<T>,
                                  currentIndex: Int, step: Int) {
        if (currentIndex < step) { return }

        if (list[currentIndex] < list[currentIndex - step]) {
            swap(list, currentIndex, currentIndex - step)
            insertToOrderArea(list, currentIndex - step, step)
        }
    }

    private tailrec fun traverseList(list: MutableList<T>, currentIndex: Int, step: Int) {
        if (currentIndex > list.size - 1) { return }

        insertToOrderArea(list, currentIndex, step)
        traverseList(list, currentIndex + 1, step)
    }

    private tailrec fun decreaseStep(list: MutableList<T>, step: Int) {
        if (step < 1) { return }

        traverseList(list, 0, step)
        decreaseStep(list, step / 3)
    }
}