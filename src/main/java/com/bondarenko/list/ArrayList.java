package com.bondarenko.list;


import com.bondarenko.Iterator;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private T array[];
    private static final int DEFAULT_SIZE = 10;//constant
    private int size;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T value) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;

    }

    @Override
    public void add(T value, int index) {
        validation(index);
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            System.arraycopy(array, index, newArray, index + 1, size);
            /*for (int j = index; j < size; j++){
                 newArray[j + 1] = array[j]; }*/
        }
        array = newArray;
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        validation(index);

        for (int i = 0; i < array.length - 1; i++) {

            if (i == index) {
                array[index] = array[index + 1];
                T[] newArray = (T[]) new Object[array.length];
                newArray[i] = array[i];
                System.arraycopy(newArray, index, array, index + 1, size);
               /* for (int j = index; j < size; j++) {
                    array[j] = array[j + 1];
                }*/
            }
        }
        size--;
        return (T) array;
    }

    @Override
    public T get(int index) {
        validation(index);
        T value = array[index];
        return (T) value;
    }

    @Override
    public T set(T newValue, int index) {
        validation(index);
        Object oldValue = array[index];
        array[index] = newValue;
        return (T) oldValue;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < array.length - 1; i++) {
            return (array[i] != value) ? false : true;
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size - 1) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }


    private void validation(int index) {
        if (index > array.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index" + index + " must be between 0 and size = " + size);
        }
    }


    @Override
    public Iterator getIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < array.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (array[index] == null) {
                throw new NoSuchElementException("No more last elements are available");
            } else
                return array[index++];
        }

        @Override
        public void remove() {
            if (array[index] == null) {
                throw new IllegalStateException("No more last elements are available");
            } else if (array[index] != null) {
                array[index] = null;//С
                size--;
            }
        }
    }
}



