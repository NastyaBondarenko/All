package com.bondarenko.testqueue;

import com.bondarenko.queue.LinkedQueue;
import com.bondarenko.queue.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest {
    Queue queue = new LinkedQueue();

    @Test
    public void addTest() {
        queue.add(1);

        assertEquals(true, queue.offer(1));
        //   assertEquals(null,queue.peek());
    }

    @Test
    public void testElement() {
        queue.add(1);
        queue.add(2);

        queue.element();

        assertEquals(1, queue.element());
        //   assertEquals("NoSuchElementException", queue.element()); як вивести, щоб пройшлов тест???
    }

    @Test
    public void testPeek() {
        queue.add(1);
        queue.peek();
        assertEquals(1, queue.peek());

        //assertEquals(null, queue.peek());
    }

    @Test
    public void testOffer() {
        queue.add(1);

        assertEquals(true, queue.offer(1));
    }

    @Test
    public void testRemove() {
        queue.add(1);
        queue.add(2);

        assertEquals(1, queue.peek());

        Object removeElement =queue.remove();

        assertEquals(2, queue.peek());
        assertEquals(1, removeElement);

    }

    @Test
    public void testPoll() {
        queue.add(1);
        queue.add(2);

        assertEquals(1, queue.peek());

        queue.poll();

        assertEquals(2, queue.peek());
         assertEquals(null,queue.poll());
    }


}
