package top.pengcheng789.algorithms.dataStruct

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
fun main(args: Array<String>) {
    val stack: Stack<Int> = LinkedStack()

    // Try to pop the empty stack.
    try {
        stack.pop()
    } catch (e: IndexOutOfBoundsException) {
        e.printStackTrace()
    }

    // Try to use the index which out of bounds.
    try {
        stack.getByIndex(100)
    } catch (e: IndexOutOfBoundsException) {
        e.printStackTrace()
    }

    (1..20).map { stack.push(it) }
    println("Element: $stack, Size: ${stack.size}")

    (1..10).map{ stack.pop() }
    println("Element: $stack, Size: ${stack.size}")

    (21..30).map { stack.push(it) }
    println("Element: $stack, Size: ${stack.size}")

    (1..5).map{ stack.pop() }
    println("Element: $stack, Size: ${stack.size}")

    stack.clean()
    println("Element: $stack, Size: ${stack.size}")
}
