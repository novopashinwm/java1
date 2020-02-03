package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length ; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    private static void swap(int[] a, int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        int [] a = {3, 5, 1, 4, 2 };
        System.out.println(Arrays.toString(a));
        ArraySort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
