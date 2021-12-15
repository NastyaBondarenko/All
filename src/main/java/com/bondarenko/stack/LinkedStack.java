package com.bondarenko.stack;


public class LinkedStack implements Stack {
    private Node first;
    private Node last;
    private int size;
    int index;

    @Override
    public boolean empty() {
        if (size == 0) {
            return true;
        }
        return true;
    }

    @Override
    public Object peek() {
        return last;
    }

    @Override
    public Object push(Object element) {
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
        return node;
    }

    @Override
    public Object pop() {
        Node node = last;
        size--;
        last.next=node;
        node=last;

        node = node.prev;
        return node.prev;
    }

    @Override
    public int search(Object element) {
        Node node = first;
        for(int index=0;index<size;index++){
            if(node.current.equals(element)){
                return index+1;
            }
            node = node.next;
        }
        return -1;
    }

    static class Node {
        Node next;//ссилки на попередній і наступний елемент
        Node prev;
        Object current;//поточний елемент

        public Node(Object current) {
            this.current = current;//Питання: чи треба ссилки зис.некст, прев? Статік
        }
    }
}
