package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, p = 2; i < n; i++, p += 2) {
            list.add(p);
        }
        return list;
    }

    public static Collection<Integer> fillOdd(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, p = 1; i < n; i++, p += 2) {
            list.add(p);
        }
        Collections.reverse(list);
        return list;
    }

    public static Collection<Integer> fill3(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n*3; i +=3) {
            list.add(i);
            list.add(i*i);
            list.add(i*i*i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Creator.fill3(3));
    }
}
