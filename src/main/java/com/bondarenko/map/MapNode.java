package com.bondarenko.map;

public interface MapNode<K,V> extends Iterable <V>{//ітерабле-бо буде ітератор
    boolean put (K key,V value);//вставка,update, якщо вставили put з двома однаковими ключами, то в мапі старе знач=новому знач, а put вертає старий ключ
    boolean delete(K key);
    V get(K key);//вернуть по ключу
    int size();
}
