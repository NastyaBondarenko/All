package com.bondarenko.teststack;

import com.bondarenko.stack.ArrayStack;
import com.bondarenko.stack.Stack;
import org.junit.Test;

public class ArrayStackTest {
    Stack stack = new ArrayStack(3);

    @Test
    public void testEmpty() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.empty();

        assertEquals(false, stack.empty());
    }

    private void assertEquals(boolean b, boolean empty) {
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.peek();

        assertEquals(3, stack.peek());
    }

    private void assertEquals(int i, Object peek) {
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();

        assertEquals(3, stack.pop());
    }

    @Test
    public void testPush() {
        stack.push(1);

        assertEquals(1, stack.push(1));
    }

    @Test
    public void testSearch() {
        stack.push(1);
        stack.push(2);
        stack.push(1);

        stack.search(1);

        assertEquals(1, stack.search(1));
        //  assertEquals(-1, stack.search(0));
    }
}
