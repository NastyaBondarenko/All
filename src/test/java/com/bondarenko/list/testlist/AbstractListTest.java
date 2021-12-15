package com.bondarenko.list.testlist;

import com.bondarenko.Iterator;
import com.bondarenko.list.List;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public abstract class AbstractListTest {
    private List list = getList();

    abstract List getList();


    @Test
    public void testCheckException() {
        //when
        boolean expectedException = false;
        try {
            list.set(2, -1);// вставить число 2 в індекс -1
            list.set(2, 11);//вставить число 2 в індекс 11, коли розмір масиву 10
        } catch (IndexOutOfBoundsException e) {
            expectedException = true;
        }
        assertTrue(expectedException);
    }

    @Test
    public void testToString() {
        //prepare
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("[A,B,C]", list.toString());
    }

    @Test
    public void testIteratorHasNext() {
        list.add("A");
        list.add("B");

        Iterator iterator = list.getIterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
        list.add("A");
        list.add("B");
        list.add("C");


        Iterator iterator = list.getIterator();
        assertEquals(3, list.size());
        assertTrue(iterator.hasNext());//В?
        iterator.next();//В

        iterator.remove();
        assertEquals(2, list.size());


    }

    @Test
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

        assertTrue(list.isEmpty());
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
        assertEquals(true, list.contains("A"));
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

    }

    @Test
    public void testNextIterator() {
        list.add("A");
        list.add("B");


        Iterator iterator = list.getIterator();

        assertTrue(iterator.hasNext());
        iterator.next();


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
    }

}
