package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
fun main(args: Array<String>) {
    SortTestTool(listOf(RecursiveShellSort(),
        RecursiveQuickSort(),
        RecursiveMergeSort())).highMode()
//    SortTestTool(listOf(RecursiveMergeSort(), RecursiveQuickSort())).normalMode(10)
}
