package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
fun main(args: Array<String>) {
    SortTestTool(listOf(ShellSort(), InsertionSort(), BubbleSort())).highMode()

//    SortTestTool(listOf(BubbleSort(), ShellSort(), InsertionSort()))
//        .normalMode(10)
}