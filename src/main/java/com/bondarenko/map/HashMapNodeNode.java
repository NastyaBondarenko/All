package com.bondarenko.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HashMapNodeNode<K, V> implements MapNode {
    private Node<K, V>[] hashTable;//  хеш-таблица, реализованная на основе массива, в якій 16 елементів за замовчуванням
    // для хранения пар «ключ-значение» в виде узлов. Здесь хранятся наши Node;
    private int size = 0; //количество пар «ключ-значение»;
    private float threshold;// предельное количество элементов, при достижении которого размер хэш-таблицы увеличиваеться


    public HashMapNodeNode() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;// capacity * loadFactor;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    private boolean addValue(int index, Node<K, V> node) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(node);//витягуємо лист нодів і вставляємо нашу ноду
        size++;
        return true;
    }

    @Override
    public boolean put(Object key, Object value) {
        Node<K, V> node = new Node(key, value);
        int index = node.hash();// отримуємо хеш-функцію

        if (hashTable[index] == null) {
            return addValue(index, node);
        }


        return false;
    }


    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
    // увеличивается вдвое. Рассчитывается по формуле (capacity * loadFactor);


    private class Node<K, V> {
        private List<Node<K, V>> nodes;//лист, де будуть зберігаться ноди
        private int hash;//хеш текущего элемента, который мы получаем в результате хеширования ключа;
        private K key;//ключ текущего элемента
        private V value;//значение текущего элемента


        private Node(K key, V value) {//конструктор, який приймає поточний ключ і значення
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return hashCode() % hashTable.length;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;

        }

        @Override
        public int hashCode() {// ці два методи, що в 1 комірку не попали два обєкти
            hash = 31;
            hash = hash * 17 * key.hashCode();// хеш-код ключа
            return hash;//хеш код
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this)// чи рівні ссилки
                return true;
            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;

        }
    }

}
