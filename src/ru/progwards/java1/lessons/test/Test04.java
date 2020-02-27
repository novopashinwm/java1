package ru.progwards.java1.lessons.test;

import java.util.ArrayDeque;

public class Test04 {
    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }

        System.out.println(deque);
    }

    ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            deque.offer(a[i]);
        }
        return deque;
    }
}
