package ru.progwards.java1.lessons.test;

import java.util.ArrayDeque;
import java.util.HashMap;

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

    HashMap<Integer, String> a2map(int[] akey, String[] aval) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < akey.length; i++) {
            map.put(akey[i], aval[i]);
        }
        return map;
    }

    int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (deque.size() ==0)
            return 0;
        return deque.getFirst() + deque.getLast();
    }

    ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            deque.offer(a[i]);
        }
        return deque;
    }
}
