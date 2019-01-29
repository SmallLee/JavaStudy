package com.lxn.test;

import java.util.Set;

public class ZGHashMap<K,V> implements ZGMap<K,V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K,V>[] table;
    private int size = 0;
    static class Node<K,V> implements Entry<K,V>{
        K k;
        V v;
        int hash;
        Node<K,V> next;
        private Node(K k,V v,Node<K,V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    private int getIndex(K k) {
        return Math.abs(k.hashCode() % DEFAULT_CAPACITY);
    }
    @Override
    public V put(K k, V v) {
        int index = getIndex(k);
        Node<K, V> node = table[index];
        if (node == null) {
            size ++;
        }
        table[index] = newNode(k,v,null);
        return table[index].getValue();
    }

    private Node<K,V> newNode(K k, V v, Node<K, V> next) {
        return new Node<>(k,v,next);
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        return false;
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
