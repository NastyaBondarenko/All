package com.bondarenko.list.testlist;

import com.bondarenko.Iterator;
import com.bondarenko.list.ArrayList;
import com.bondarenko.list.LinkedList;
import com.bondarenko.list.List;
import com.bondarenko.map.HashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest extends AbstractListTest{


    @Override
    List getList() {
        List list = new LinkedList();
        return list;
    }

   /* @Test
    public void testClear() {
        //prepare
        list.add("A");

        //when
        list.clear();

        //than
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        list.add("B");
        list.add("A");

        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        list.add("A");
        list.add("B");

        assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd() {
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
    }

    @Test
    public void testAddValueWithIndex() {

        list.add("A");
        list.add("B");
        list.add("C", -0);

        assertEquals("C", list.get(0));
    }

    @Test
    public void testGetElement() {
        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
    }

    @Test
    public void testGet() {
        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
    }

    @Test
    public void testSet() {
        list.add("A");
        list.add("B");

        //when
        list.set("C", 0);

        //than
        assertEquals("C", list.get(0));
    }


    @Test
    public void testContains() {
        list.add("A");
        list.add("B");


        //than
        assertEquals(true, list.contains("C"));
    }

    @Test
    public void testIndexOf() {
        //prepare
        list.add("A");
        list.add("C");
        list.add("A");

        //than
        //  assertEquals(0, list.indexOf("A"));
        assertEquals(-1, list.lastIndexOf("B"));
    }

    @Test
    public void testLastIndexOf() {
        //prepare
        list.add("A");
        list.add("A");
        list.add("C");

        //than
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(-1, list.lastIndexOf("C"));
    }

    @Test
    public void testRemove() {
        //prepare
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        //when
        list.remove(2);

        //than

        assertEquals("B", list.get(1));
        //  assertEquals(null,list.get(2));
        assertEquals("D", list.get(2));
    }

    @Test
    public void testHasNextIterator() {
        list.add("A");
        list.add("B");

        Iterator iterator = list.getIterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNextIterator() {
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator iterator = list.getIterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());


    }

    @Test
    public void testRemoveIterator() {
        list.add("A");
        list.add("B");
        list.add("C");


        Iterator iterator = list.getIterator();


        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        assertEquals(2, list.size());
    }*/

}