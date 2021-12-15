package com.bondarenko.testqueue;

import com.bondarenko.queue.ArrayQueue;
import com.bondarenko.queue.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayQueueTest {
    Queue queue = new ArrayQueue(3);

    @Test
    public void testAdd() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
    }

    @Test
    public void testOffer() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(true, queue.offer(1));
        assertEquals(true, queue.offer(2));
        assertEquals(true, queue.offer(3));
        //assertEquals(false,queue.offer(4));

    }

    @Test
    public void testPeek() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.peek();

        assertEquals(1, queue.peek());
        // assertEquals(null, queue.peek());
    }

    @Test
    public void testElement() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.element();

       // assertEquals(1, queue.element());
        assertEquals("NoSuchElementException", queue.peek());
    }

    @Test
    public void testPoll() {
        queue.add(1);
        queue.add(2);
        queue.add(1);

        queue.poll();
        queue.peek();

        assertEquals(1, queue.poll());
        assertEquals(2, queue.peek());
    }

    @Test
    public void testRemove() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.remove();
        assertEquals(1, queue.remove());
       // assertEquals(2, queue.peek());
    }
}










