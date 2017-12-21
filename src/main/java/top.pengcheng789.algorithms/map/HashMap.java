package top.pengcheng789.algorithms.map;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @autor pen
 */
public class HashMap<K, V> implements Map<K, V> {

    /**
     * The HashMap size is less than length of node array multiply by TIMES.
     * The TIMES is between 0 and 1.
     */
    private static final float TIMES = 0.8f;

    private Node<K, V>[] nodes;
    private int size;
    private Set<Entry<K, V>> entrySet = new HashSet<>();

    /**
     * Removes all of the mappings from this map (optional operation).
     */
    @Override
    public void clear() {
        nodes = null;
        entrySet = new HashSet<>();
        size = 0;
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        entrySet.stream().forEach(entry -> keySet.add(entry.getKey()));
        return keySet;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     */

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : entrySet) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Associates the specified value with the specified key
     * in this map (optional operation).
     */
    @Override
    public V put(K key, V value) {
        setSuitableSize();
        return insertNode(new Node<>(key, value), false);
    }

    /**
     * Copies all of the mappings from the specified map to this
     * map (optional operation).
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a Set view of the mappings contained in this map.
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a Collection view of the values contained in this map.
     */
    @Override
    public Collection<V> values() {
        Collection<V> valueList = new ArrayList<>();
        entrySet.stream().forEach(entry -> valueList.add(entry.getValue()));
        return valueList;
    }

    /**
     * Removes the mapping for a key from this map if it is present (optional operation).
     */
    @Override
    public V remove(Object key) {
        int index = generateIndex(key.hashCode(), nodes.length);
        V value = get(key);

        if (nodes[index].getKey() == key || nodes[index].getKey().equals(key)) {
            entrySet.remove(nodes[index]);
            nodes[index] = nodes[index].next;
            size--;
        } else {
            for (Node<K, V> node = nodes[index]; node.next != null; node = node.next) {
                if (node.next.getKey() == key || node.next.getKey().equals(key)) {
                    node.next = node.next.next;
                    entrySet.remove(key);
                    size--;
                    break;
                }
            }
        }

        return value;
    }

    /**
     * Returns the value to which the specified key is mapped, or null
     * if this map contains no mapping for the key.
     */
    @Override
    public V get(Object key) {
        for (Entry<K, V> entry : entrySet) {
            if (entry.getKey() == key || entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Set a suitable size of Node array.
     */
    private void setSuitableSize() {
        if (nodes == null) {
            nodes = (Node<K, V>[]) Array.newInstance(Node.class, 16);
            return;
        }

        if (size >= nodes.length * TIMES) {
            Node<K, V>[] oldNodes = nodes;
            nodes = (Node<K, V>[]) Array.newInstance(Node.class, nodes.length << 1);
            reallocation(oldNodes);
        }
    }

    /**
     * Reallocation position from old Node array to new array.
     */
    private void reallocation(Node<K, V>[] oldNodes) {
        Arrays.stream(oldNodes).forEach(node -> {
            for (Node<K, V> n = node; n != null; n = n.next) {
                insertNode(n, true);
            }
        });
    }

    /**
     * Insert a node in node array.
     */
    private V insertNode(Node<K, V> node, boolean isReallocation) {
        int index = node.getKey() == null ?
                0 : generateIndex(node.getKey().hashCode(), nodes.length);

        if (!isReallocation) {
            entrySet.add(node);
        }

        if (nodes[index] == null) {
            nodes[index] = node;
            if (!isReallocation) {
                size++;
            }
            return node.getValue();
        }

        // It need to consider duplicate key when `isReallocation` is false.
        if (!isReallocation) {
            for (Node<K, V> n = nodes[index]; n != null; n = n.next) {
                if (n.getKey() == node.getKey() || n.getKey().equals(node.getKey())) {
                    n.setValue(node.getValue());
                    return node.getValue();
                }
            }
        }

        node.next = nodes[index];
        nodes[index] = node;
        if (!isReallocation) {
            size++;
        }
        return node.getValue();
    }

    /**
     * Returns the index of node array.
     */
    private static int generateIndex(int hashCode, int arrayLength) {
        return hashCode & (arrayLength - 1);
    }


    /**
     * The node of Map.
     */
    private final class Node<K, V> implements Entry<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Return the key.
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Return the value.
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Set the value.
         */
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
