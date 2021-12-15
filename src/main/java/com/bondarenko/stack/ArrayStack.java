package com.bondarenko.stack;


public class ArrayStack implements Stack {
    private int front;
    private int rear;
    private int capacity;
    private Object[] array;

    public ArrayStack(int size) {
        front = rear = 0;
        capacity = size;
        array = new Object[capacity];
    }


    @Override
    public boolean empty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    @Override
    public Object peek() {
        return rear;
    }

    @Override
    public Object pop() {
        capacity--;
        return array[rear];
    }

    @Override
    public Object push(Object element) {
        array[rear] = element;
        capacity++;
        return element;
    }

    @Override
    public int search(Object element) {
        for (int i = 0; i < capacity; i++) {
            if (array[i] == element) {
                return i+1;//вертає не індекс його, а порядковий номер в списку від вершини
            }else
                return -1;
        }
        return -1;
    }
}
