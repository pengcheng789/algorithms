package top.pengcheng789.algorithms.sort

/**
 *
 * @author pen
 */
fun main(args: Array<String>) {
    SortTestTool(listOf(RecursiveShellSort(),
        LoopShellSort(),
        RecursiveQuickSort(),
        LoopQuickSort())).highMode()
}
