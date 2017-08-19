package top.pengcheng789.algorithms.dataStruct

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
class LinkedBag<T>: Bag<T>() {

    private var first: Node<T>? = null

    override fun add(value: T) {
        val oldFirst = first
        first = Node(value)
        first!!.next = oldFirst
        size++
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