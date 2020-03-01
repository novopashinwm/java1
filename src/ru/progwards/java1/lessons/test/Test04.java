package ru.progwards.java1.lessons.test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test04 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "Один");
        map.put(9, "Девять");
        Test04 t = new Test04();
        t.checkAndAdd(map, 0, "Zero");
        t.checkAndAdd(map, 3, "Три");
        t.checkAndAdd(map, 2, "Два");
        t.checkAndAdd(map, 3, "Three");
        t.checkAndAdd(map, 10, "Ten");

        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }

        System.out.println(deque);
    }

    void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value) {
        if (map.size() != 0 && !map.containsKey(key) && (key< map.lastKey())
                && (key >map.firstKey()) ) {
            map.put(key,value);
        }
    }

    int fillHoles(Map<Integer, String> map, int size) {
        int cnt = 0;
        for (int i = 1; i <= size; i++) {
           if ( map.putIfAbsent(i,"Число " + i) == null) {
               cnt++;
           }
        }
        return cnt;
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
