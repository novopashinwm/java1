package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;
    private int length = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
        length = array.length;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < length;
    }

    @Override
    public T next() {
        return array[++index];
    }
}