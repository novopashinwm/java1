package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) {
        for (int i = a.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
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
