package top.pengcheng789.algorithms.dataStruct

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
fun main(args: Array<String>) {
    val queue: Queue<Int> = LinkedQueue()

    (1..10).map { queue.enQueue(it) }
    println("Element: $queue, Size: ${queue.size}")

    print("Dequeue: ")
    (0..4).map { print("${queue.deQueue()} ") }
    println()
    println("Element: $queue, Size: ${queue.size}")

    queue.clean()
    println("Element: $queue, Size: ${queue.size}")
}