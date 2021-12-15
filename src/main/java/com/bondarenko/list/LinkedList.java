package com.bondarenko.list;


import com.bondarenko.Iterator;
import com.bondarenko.list.List;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(T value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;
            newNode.next = last;
            last = newNode;
        } else if (size > 0) {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        first = last;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && first == null && last == null;
    }

    @Override
    public void add(T value, int index) {
        validation(index);
        Node newNode = new Node(value);
        if (index == size) {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        } else if (index == 0) {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        } else {
            Node node = getElement(index);
            newNode.prev = node.prev;
            node.prev.next = node;
            node = newNode;
            newNode.next = node.next;
        }
        size++;
    }

    public Node getElement(int index) {
        Node newNode = first;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                newNode = newNode.next;
            }
        }
        return newNode;
    }

    @Override
    public T get(int index) {
        validation(index);
        return (T) getElement(index).current;
    }

    @Override
    public T set(T value, int index) {
        validation(index);
        Node node = getElement(index);
        node.current = value;
        return (T) node.current;
    }

    @Override
    public boolean contains(Object value) {
        Node node = new Node(value);
        if (node.current == value)
            return true;
        else
            return false;
    }

    @Override
    public int indexOf(Object value) {
        Node newNode = first;
        for (int index = 0; index < size; index++) {
            if (newNode.current == value) {
                return index;
            }
            newNode = newNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node newNode = last;
        for (int index = size - 1; index > 0; index--) {
            if (newNode.current == value) {
                return index;
            }
            newNode = newNode.prev;
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        validation(index);
        Object result = first.current;
        if (index == 0) {
            first = first.next;
            first.prev = null;
        }
        if (index == size - 1) {
            result = last.current;
            last = last.prev;
            last.next = null;
        }
        if (size == 1) {
            first = last = null;
        } else {
            Node node = getElement(index);
            node.prev.next = node.next;
        }

        size--;
        return (T) result;
    }

    private void validation(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index" + index + " must be between 0 and size = " + size);
        }
    }


    public String toString(){
        Node current=first;
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
                while (current!=null){
                    stringJoiner.add(String.valueOf(current.current));
                    current=current.next;
                }
                return stringJoiner.toString();
    }

    @Override
    public Iterator getIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
        private Node node = first;
        private boolean okToCallNext;

        @Override
        public boolean hasNext() {
            if (node.next != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (node == last) {
                throw new NoSuchElementException("No more last elements are avalible");
            }
            okToCallNext = true;
            if (node.next != null) {
                node = node.next;
            } else {
                node = first;
            }
            return node.current;
        }

        @Override
        public void remove() {
            if (node.next != null) {
                last = node.prev;
                node.prev.next = null;

            } else {
                throw new IllegalStateException("The method next() not used previously ");
            }
            size--;

        }
    }

    private static class Node {
        private Object current;//поточний елемент
        private Node next;//ссилки на попередній і наступний елемент
        private Node prev;

        private Node(Object current) {
            this.current = current;//
        }
    }
}













