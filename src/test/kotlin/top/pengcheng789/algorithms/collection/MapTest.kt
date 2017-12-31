package top.pengcheng789.algorithms.collection

/**
 * @author pen
 */
fun main(args: Array<String>) {
    val map = HashMap<String, String>()

    map.put("zhigu", "bolin")
    map.put("yaomei", "cuiying")
    map.put("fenghua", "run")

    val value = map.remove("zhigu")

    println("remove: " + value)
    println("size: " + map.size)

    map.forEach { key, value ->  println(key + ": " + value)}
}