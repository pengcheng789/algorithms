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

package top.pengcheng789.algorithms.dataStruct.stack

import top.pengcheng789.algorithms.dataStruct.Node

/**
 * CreateDate:2017-08-18
 *
 * @author pen
 */
class LinkedStack<T>: Stack<T>() {

    private var first: Node<T>? = null

    override fun push(value: T) {
        val oldFirst = first
        first = Node(value)
        first!!.next = oldFirst
        size++
    }

    override fun pop(): T {
        if (size <= 0) throw IndexOutOfBoundsException("The stack is empty.")
        val oldFirst = first
        first = if (size-- == 1) null else first!!.next

        return oldFirst!!.value
    }

    /**
     * Begin with 0
     */
    override fun getByIndex(index: Int): T {
        if (index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        var node = first
        (1..index).map { node = node!!.next }

        return node!!.value
    }

    override fun clean() {
        first = null
        size = 0
    }
}