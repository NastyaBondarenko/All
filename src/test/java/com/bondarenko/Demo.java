package com.bondarenko;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Demo {
    Queue q= new LinkedList();

    @Test
    public void testPoll(){
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek());


    }
}
