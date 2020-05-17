package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

public class DynamicArray<T> {
    int count = 0;

    private T[] arr;

    public DynamicArray() {
        arr = (T[]) new Object[1];
    }

    public void add (T element){

        ++ count;
        if (count > arr.length){
            arr = Arrays.copyOf(arr, arr.length*2);
        }
        arr[count-1]= element;
    }

    public void insert (int pos, T num){

        ++ count;
        if (count > arr.length){
            arr = Arrays.copyOf(arr, arr.length*2);
        }

        T[] b = (T[]) new Object[arr.length];
        System.arraycopy(arr, 0, b, 0, pos);
        b[pos] = num;
        System.arraycopy(arr, pos, b, pos + 1, arr.length - pos -1);
        arr = Arrays.copyOf(b, b.length);
    }

    public void remove(int pos){
        --count;

        T[] b1 = (T[]) new Object[arr.length];
        System.arraycopy(arr, 0, b1, 0, pos);
        System.arraycopy(arr, pos+1, b1, pos, arr.length - pos-1);
        arr = Arrays.copyOf(b1, b1.length);

    }

    public T get(int pos){

        return arr[pos];
    }

    public int size(){
        return arr.length;
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
