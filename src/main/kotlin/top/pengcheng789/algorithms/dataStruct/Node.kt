package top.pengcheng789.algorithms.dataStruct

/**
 * CreateDate:2017-08-18
 *
 * @author pen
 */
internal data class Node<T> (
        var value: T,
        var next: Node<T>? = null,
        var previous: Node<T>? = null
)