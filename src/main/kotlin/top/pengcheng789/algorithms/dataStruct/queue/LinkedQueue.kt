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

package top.pengcheng789.algorithms.dataStruct.queue

import top.pengcheng789.algorithms.dataStruct.Node

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
class LinkedQueue<T>: Queue<T>() {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun enQueue(value: T) {
        val oldTail = tail
        tail = Node(value)
        tail!!.next = oldTail
        oldTail?.previous = tail

        if (size++ == 0) head = tail
    }

    override fun deQueue(): T {
        if (size <= 0 ) throw IndexOutOfBoundsException("The queue is empty.")
        val oldHead = head
        if (size-- == 1) {
            head = null
            tail = null
        }
        else {
            head = head!!.previous
            head!!.next = null
        }

        return oldHead!!.value
    }

    override fun getByIndex(index: Int): T {
        if (index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }

        var node = tail
        (1..index).map { node = node!!.next }

        return node!!.value
    }

    /**
     * Note: Although the queue has circular references, java gc will collect them.
     */
    override fun clean() {
        head = null
        tail = null
        size = 0
    }
}