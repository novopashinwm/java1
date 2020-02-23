package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int index = -1;
    private int m = 0, n = 0;


    public MatrixIterator(T[][] array) {
        this.array = array;
        this.m = array[0].length;
        this.n = array.length;

    }

    @Override
    public boolean hasNext() {
        return (index + 1)< (m * n);
    }

    @Override
    public T next() {
        index++;
        return array[index/m][index % m];
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][] { {1,2,3,4,5}
                                  , {6,7,8,9,0}};
        MatrixIterator<Integer> matrix = new MatrixIterator<>(arr);

        for ( ; matrix.hasNext() ; ) {
            System.out.println(matrix.next());
        }
    }
}
