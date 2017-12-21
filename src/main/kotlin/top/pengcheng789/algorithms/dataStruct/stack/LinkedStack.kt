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