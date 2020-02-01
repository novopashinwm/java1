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
            System.arraycopy(b, 0, a, 0, pos -1);
            for (int i = pos + 1; i < b.length; i++) {
                a[i-1] = b[i];
            }
        }
    }

    private boolean checkBound(int pos) {
        return (a!=null && pos < a.length);
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
        da.add(52);
        da.add(21);
        da.add(87);
        da.add(20);
        da.add(-30);
        da.add(33);
        da.add(42);
        da.add(-70);
        da.add(97);
        da.add(49);
        da.add(-57);
        da.add(-28);
        da.add(-92);
        da.add(-15);
        da.add(94);
        da.add(-91);
        da.add(-51);
        da.add(-47);
        da.add(79);
        System.out.println(da.at(18));
        System.out.println(da);
        da.atInsert(1,4);
        System.out.println(da);
    }
}
