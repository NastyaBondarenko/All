package com.bondarenko.map;

public interface Map <K,V>{
    K put(K key, V value);//update


    K remove(K key);

    K get(K key);
    V putIfAbsent(K key,V value);

    int size();

    boolean isEmpty();

    boolean containsKey(K key);


    int getIterator();
}
