package com.bondarenko.queue;


import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {
    private int front;
    private int rear;
    private int capacity;
    private Object[] queue;


    public ArrayQueue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new Object[capacity];
    }

    @Override
    public void add(Object element) {
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        } else {
            queue[rear] = element;
            rear++;
        }
    }

    @Override
    public boolean offer(Object element) {
        if (capacity == rear) {
            return false;
        } else
            queue[rear] = element;
        capacity++;
        return true;
    }

    @Override
    public Object peek() {
        if (front == rear) {
            return null;
        } else
            return queue[front];
    }

    @Override
    public Object element() {
        if (front == rear) {
            throw new NoSuchElementException("");
        }
        return queue[front];
    }

    @Override
    public Object poll() {
        if (front == rear) {
            return null;
        } else
            capacity--;
        front = front%capacity;// вертає видалений 1-ий елемент
        return queue[front++];//Вийшли на голову, зменшили її і прибавляємо +1 до голови
    }

    @Override
    public Object remove() {
        if (front == rear) {
            System.out.println("NoSuchElementException");
        } else
            capacity--;
        front = front % capacity;// вертає видалений 1-ий елемент
        return queue[front++];//Вийшли на голову, зменшили її і прибавляємо +1 до голови
    }
}


