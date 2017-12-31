package top.pengcheng789.algorithms.collection

/**
 * @author pen
 */
class HashMap<K, V>: MutableMap<K, V> {

    override val keys: MutableSet<K>
        get() {
            val keySet = HashSet<K>()
            entries.forEach { entry -> keySet.add(entry.key) }
            return keySet
        }

    override val values: MutableCollection<V>
        get() {
            val valueList = ArrayList<V>()
            entries.forEach { entry -> valueList.add(entry.value) }
            return valueList
        }

    override val entries = HashSet<MutableMap.MutableEntry<K, V>>()

    override var size = 0

    private var nodes = arrayOfNulls<Node<K, V>>(16)

    override fun containsKey(key: K): Boolean {
        return get(key) != null
    }

    override fun containsValue(value: V): Boolean {
        entries.forEach { entry -> if (entry.value == value) return true }

        return false
    }

    override fun get(key: K): V? {
        entries.forEach { entry -> if (entry.key == key) return entry.value }

        return null
    }

    override fun put(key: K, value: V): V? {
        setSuitableSize()
        return insertNode(Node(key, value), false)
    }

    override fun putAll(from: Map<out K, V>) {
        from.forEach { key, value -> put(key, value) }
    }

    override fun remove(key: K): V? {
        if (!containsKey(key)) {
            return null
        }

        val index = generateIndex(key, nodes.size)

        if (nodes[index]!!.key == key) {
            val oldValue = nodes[index]!!.value
            removeEntryFromSet(nodes[index])
            nodes[index] = nodes[index]!!.next
            return oldValue
        }

        var node = nodes[index]
        while (node!!.next != null) {
            if (node.next!!.key == key) {
                val n = node.next
                node.next = n!!.next
                size--
                return n.value
            }

            node = node.next
        }

        return null
    }

    override fun clear() {
        nodes = arrayOfNulls(16)
        size = 0
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    private fun setSuitableSize() {
        if (nodes.size < size) {
            val oldNodes = nodes
            nodes = arrayOfNulls(nodes.size shl 1)
            reallocation(oldNodes)
        }
    }

    private fun reallocation(oldNodes: Array<Node<K, V>?>) {
        oldNodes.forEach { node -> if (node != null) insertNode(node, true)}
    }

    private fun insertNode(node: Node<K, V>, reallocation: Boolean): V? {
        val index = generateIndex(node.key, nodes.size)

        if (nodes[index] == null) {
            nodes[index] = node
            if (!reallocation) {
                addEntryToSet(node)
            }
            return null
        }

        // It need to consider duplicate key when `isReallocation` is false.
        if (!reallocation) {
            var n = nodes[index]!!.next
            while (n != null) {
                if (node.key == n.key) {
                    val oldValue = n.value
                    n.value = node.value
                    return oldValue
                }

                n = n.next
            }
        }

        node.next = nodes[index]
        nodes[index] = node
        if (!reallocation) {
            addEntryToSet(node)
        }
        return null
    }

    private fun addEntryToSet(node: Node<K, V>) {
        entries.add(node)
        size++
    }

    private fun removeEntryFromSet(node: Node<K, V>?) {
        if (node != null) {
            entries.remove(node)
        }
        size--
    }

    private fun generateIndex(key: K?, arraySize: Int): Int {
        if (key == null) {
            return 0
        }

        return key.hashCode() and ( arraySize - 1)
    }

    inner class Node<K, V>: MutableMap.MutableEntry<K, V> {

        override val key: K
        override var value: V

        var next: Node<K, V>?

        constructor(key: K, value: V) {
            this.key = key
            this.value = value
            this.next = null
        }

        override fun setValue(newValue: V): V {
            value = newValue
            return value
        }

    }
}
