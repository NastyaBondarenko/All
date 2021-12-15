package com.bondarenko.queue;

public class LinkedQueue implements Queue {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(Object element) {
        Node node = new Node(element);
        if (size == 0) {
            first = node;
            node.next = last;
            last = node;
        } else if (size > 0) {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    @Override
    public Object element() {
        if (size == 0) {
            System.out.println("NoSuchElementException");
        }
        return first.current;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return first.current;
    }


    @Override
    public boolean offer(Object element) {
        Node node = new Node(element);
        if (last.current == element) {
            return true;
        } else
            return false;

    }

    @Override
    public Object remove() {
        Node node = first;
        Object result = first.current;
        if (size == 0) {
            System.out.println("NoSuchElementException");
        }
        size--;
        first = node.next;
        node.next = first;
        return result;
    }


    @Override
    public Object poll() {
        Node node = first;
        if (size == 0) {
            return null;
        } else
            size--;
        first = node.next;
        node.next = first;
        return first;

    }

    static class Node {
        Object current;//поточний елемент
        Node next;//ссилки на попередній і наступний елемент
        Node prev;

        public Node(Object current) {
            this.current = current;//Питання: чи треба ссилки зис.некст, прев? Статік
        }
    }
}
