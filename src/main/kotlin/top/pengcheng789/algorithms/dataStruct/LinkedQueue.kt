package top.pengcheng789.algorithms.dataStruct

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