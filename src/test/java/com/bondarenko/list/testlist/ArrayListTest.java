package com.bondarenko.list.testlist;

import com.bondarenko.Iterator;
import com.bondarenko.list.ArrayList;
import com.bondarenko.list.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest extends AbstractListTest{


    @Override
    List getList() {
         List<Object> list = new ArrayList();
        return list;
    }

   /* @Test
    public void testAdd() {
        list.add("A");
        list.add("B");
          assertEquals(2, list.size());
    }


    @Test
    public void testAddValueWithIndex() {
        //when
        list.add("A");
        list.add("B");
        list.add("C", 0);
        list.add("K", 2);

        //than
        assertEquals(4, list.size());
        assertEquals("C", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("K", list.get(2));
        assertEquals("B", list.get(3));
    }

    @Test
    public void testArrayIsGrowOverTenElements() {
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("C");
        list.add("A");
        list.add("X");
        list.add("A");
        list.add("A");
        list.add("A");
        assertEquals(11, list.size());
        assertEquals("C", list.get(5));
    }

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
    public void testRemove() {
        //prepare
        list.add("A");
        list.add("B");
        list.add("C");

        //when
        list.remove(1);

        //than
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testLastIndexOf() {
        //prepare
        list.add("A");
        list.add("A");

        //than
        assertEquals(1, list.<Object>lastIndexOf("A"));
        assertEquals(-1, list.<Object>lastIndexOf("C"));
    }

    @Test
    public void testIndexOf() {
        //prepare
        list.add("A");
        list.add("C");
        list.add("A");

        //than
        // assertEquals(0, list.indexOf("A"));
        assertEquals(-1, list.<Object>indexOf("B"));
    }

    @Test
    public void testIsEmpty() {
        list.add("A");
        list.add("B");
        assertTrue(list.<Object>contains("A"));
    }

    @Test
    public void testClear() {
        //prepare
        list.add("A");
        assertEquals(1, list.size());

        //when
        list.clear();

        //than
        assertEquals(0, list.size());
    }

    @Test
    public void testSet() {
        list.<Object>add("A");
        list.<Object>add("B");

        //when
        list.<Object>set("C", 0);

        //than
        assertEquals("C", list.get(0));
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
    public void testIteratorNext() {
        list.add("A");
        list.add("B");

        Iterator iterator = list.getIterator();
        assertEquals("A", iterator.next());

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


    }*/
}



