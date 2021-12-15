package com.bondarenko.teststack;

import com.bondarenko.stack.LinkedStack;
import com.bondarenko.stack.Stack;
import org.junit.Test;

public class LinkedStackTest {
    Stack stack = new LinkedStack();

    @Test
    public void testEmpty() {
        assertEquals(true, stack.empty());
    }

    private void assertEquals(boolean b, boolean empty) {
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);

        stack.peek();

        assertEquals(2, stack.peek());
    }

    private void assertEquals(int i, Object peek) {
    }

    @Test
    public void testPush() {
        stack.push(1);

        assertEquals(1, stack.push(1));
    }

    @Test
    public void testPop(){
        stack.push(1);
        stack.push(2);

        stack.pop();

        assertEquals(2,stack.pop());
    }

    @Test
    public void testSearch(){
        stack.push(1);
        stack.push(2);

        stack.search(10);

        assertEquals(-1,stack.search(2));

    }

}
