package com.bondarenko.hashmap;

import com.bondarenko.Iterator;
import com.bondarenko.map.HashMap;
import com.bondarenko.map.Map;

import org.junit.Test;

//import java.util.HashMap;
//import java.util.Map;

import static org.junit.Assert.*;


public class HashMapTest {
    private Map hashMap = new HashMap();

    @Test
    public void testPut() {
        assertNull(hashMap.put("key1", "value1"));
        assertEquals(1, hashMap.size());

        hashMap.put("key2", "value2");
        assertEquals(2, hashMap.size());

        hashMap.put("key1", "value3");
        assertEquals("value3", hashMap.put("key1", "value3"));
    }

    @Test
    public void testRemove() {
        assertNull(hashMap.put("key1", "value1"));
        hashMap.put("key2", "value2");
        assertEquals(2, hashMap.size());

        hashMap.remove("key1");
        assertEquals(1, hashMap.size());

        hashMap.remove("key2");
        assertEquals(0, hashMap.size());
    }

    @Test
    public void testGet() {

        assertNull(hashMap.get("key1"));

        hashMap.put("key1", "value1");
        assertEquals("value1", hashMap.get("key1"));

        hashMap.put("key2", "value2");
        assertEquals("value2", hashMap.get("key2"));

        hashMap.put("key2", "value3");
        assertEquals("value3", hashMap.get("key2"));
    }

    @Test
    public void testSize() {
        assertEquals(0, hashMap.size());

        hashMap.put("key2", "value2");
        assertEquals(1, hashMap.size());

        hashMap.put("key3", "value3");
        assertEquals(2, hashMap.size());
    }

    @Test
    public void testContainsKey() {
        assertFalse(hashMap.containsKey("key1"));

        assertNull(hashMap.put("key2", "value3"));
        assertTrue(hashMap.containsKey("key2"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hashMap.isEmpty());

        hashMap.put("key2", "value3");
        assertFalse(hashMap.isEmpty());

        hashMap.put("key3", "value3");

        hashMap.put("key4", "value3");
        hashMap.put("key5", "value3");
        hashMap.put("key6", "value3");
        hashMap.put("key7", "value3");
    }

    @Test
    public void testputIfAbsent() {
        assertNull(hashMap.putIfAbsent("key1", "value1"));

        hashMap.put("key1", "value1");
        assertEquals("value1", hashMap.putIfAbsent("key1", "value2"));
    }

    @Test
    public void testIteratorHasNext() {
        hashMap.put("key4", "value4");
        hashMap.put("key5", "value5");
        hashMap.put("key6", "value6");

   //     Iterator iterator = hashMap.getIterator();
   //     assertTrue(iterator.hasNext());
    }

}
