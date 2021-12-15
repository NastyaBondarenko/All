package com.bondarenko.map;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;



public class HashMap<K, V> implements Map<K, V> {
    private static final int INITIAL_CAPACITY = 5;//константа
    private ArrayList<Entry<K, V>>[] buckets = new ArrayList[INITIAL_CAPACITY];
    private int size;


    private static final int GROWTH_FACTOR = 2;
    private static double DEFAULT_LOAD_FACTOR = 0.75;

    public HashMap() {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {//заповнюємо buckets ерейлістами
            buckets[i] = new ArrayList();
            if (buckets.length * DEFAULT_LOAD_FACTOR < size) {
                buckets[buckets.length] = buckets[INITIAL_CAPACITY * GROWTH_FACTOR];
            }
        }
    }

    @Override
    public K put(K key, V value) {
        ArrayList<Entry<K, V>> bucket = buckets[getIndex(key)];// get bucket
        Entry<K, V> newEntry = new Entry<>(key, value);//new Entry
        int index = bucket.indexOf(newEntry);// вертає index -перевірка чи є  з таким ключом
        K result;
        if (index == -1) {
            bucket.add(newEntry);
            result = null;
            size++;
        } else {
            Entry<K, V> oldValue = bucket.get(index);// значення попередньої Value по індексу
            result = (K) oldValue.value;
            oldValue.value = value;
        }
        return result;
    }

    @Override
    public K remove(K key) {
        ArrayList<Entry<K, V>> bucket = buckets[getIndex(key)];// get bucket
        Entry<K, V> newEntry = new Entry<>(key, null);//new Entry
        int index = bucket.indexOf(newEntry);//
        if (index == -1) {
            return null;
        } else {
            K result = (K) bucket.get(index);
            bucket.remove(index);
            size--;
            return result;
        }
    }

    @Override
    public K get(K key) {
        ArrayList bucket = buckets[getIndex(key)];
        Entry<K, V> newEntry = new Entry<>(key, null);//new Entry
        int index = bucket.indexOf(newEntry);//
        K result;
        if (index == -1) {
            return null;
        } else {
            Entry oldValue = (Entry) bucket.get(index);
            result = (K) oldValue.value;
            oldValue.value = oldValue;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        ArrayList bucket = buckets[getIndex(key)];
        Entry<K, V> newEntry = new Entry<>(key, null);
        int index = bucket.indexOf(newEntry);//
        if (index == -1) {
            return false;
        } else
            return true;
    }

    @Override
    public int getIterator() {
        return 0;
    }


    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private void add(K key, V value) {
        add(key, value, buckets);
        size++;
    }

    private void add(K key, V value, ArrayList<Entry<K, V>>[] newBuckets) {
        int index = getIndex(key, newBuckets);
        if (newBuckets[index] == null) {
            newBuckets[index] = new ArrayList<>();
        }
        newBuckets[index].add(new Entry<>(key, value));
    }

    private Entry getEntry(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> current : buckets[index]) {
                if (Objects.equals(current.key, key)) {
                    return current;
                }
            }
        }
        return null;
    }


    @Override
    public V putIfAbsent(K key, V value) {
        Entry<K, V> result = getEntry(key);
        if (result == null) {
            add(key, value);
            return null;
        }
        return result.value;
    }

    public String toString() {
        return null;
    }



        //new HashMapIterator<K,V>();


    public class HashMapIterator<K,V> implements Iterator<HashMap.Entry<K,V>> {

        private HashMap<K,V> map = null;
        private Iterator<HashMap.Entry<K,V>>iter = null;
        private HashMap.Entry<K, V> lastEntry = null;

        public HashMapIterator(HashMap<K,V> map,Iterator<HashMap.Entry<K,V>>iter){
            this.map = map;
            this.iter = iter;
        }
        @Override
        public boolean hasNext() {
            if (iter==null)
                return false;
            return iter.hasNext();
        }

        @Override
        public HashMap.Entry<K,V> next() {
            if (iter==null)
                return null;

            lastEntry = iter.next();
            return  lastEntry;
        }

        @Override
        public void remove() {
            if (iter==null || lastEntry==null)
                return;

            map.remove(lastEntry.getKey());
            iter.remove();
        }
    }
    private static class Entry<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (o.getClass() == Entry.class) {
                Entry that = (Entry) o;
                if (!key.equals(that.key)) {
                    return false;
                }
                return true;
            }
            return false;
        }

    }

    private int getIndex(K key) {
        return getIndex(key, buckets);
    }

    private int getIndex(K key, ArrayList[] buckets) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % buckets.length); //hashCode свій, перевірить щоб був по модулю!
    }


}
       /* private int getIndex(Object key) {
        int result = Math.abs(key.hashCode() % buckets.length);//індекс куди кладемо value (% бо ніколи не вийде за межі масиву)
        return result;//index
    }*/

//        @Override
//        public int hashCode() {
//            int hash = 31;
//            hash = hash * 17 * key.hashCode();
//            return hash;
//        }

