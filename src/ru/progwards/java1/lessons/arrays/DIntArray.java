package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    private int[] a;
    private int[] b;

    public void add(int num) {
        if (a == null) {
            a = new int[1];
            a [0] = num;
        } else {
            b = new int[a.length + 1];
            System.arraycopy(a,0, b,0, a.length);
            b[b.length-1] = num;
            a = new int[a.length + 1];
            a = Arrays.copyOf(b, b.length);
        }
    }

    public void atInsert(int pos, int num) {
        if (checkBound(pos)) {
            b = new int[a.length + 1];
            System.arraycopy(a,0, b,0, a.length);
            //Не придумал как стандартными функциями обойтись
            for (int i = pos + 1; i < b.length ; i++) {
                b[i] = a[i-1];
            }
            b[pos] = num;
            a = new int[a.length + 1];
            a = Arrays.copyOf(b, b.length);
        }
    }

    public void atDelete(int pos) {
        if (checkBound(pos)) {
            b = new int[a.length];
            b = Arrays.copyOf(a, a.length);
            a = new int[a.length - 1];
            a = Arrays.copyOf(b, pos -1);
            for (int i = pos + 1; i < b.length; i++) {
                a[i-1] = b[i];
            }
        }
    }

    private boolean checkBound(int pos) {
        return (a!=null && pos < a.length-1);
    }

    public int at(int pos) {
        //Специально сделал, чтобы "не стрелял" exception
        if (!checkBound(pos)) {
            return -1;
        }
        return a[pos];
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }

    public static void main(String[] args) {
        DIntArray da = new DIntArray();
        System.out.println(da);
        da.add(1);
        da.add(2);
        da.add(3);
        System.out.println(da);
        da.atInsert(1,4);
        System.out.println(da);
    }
}
