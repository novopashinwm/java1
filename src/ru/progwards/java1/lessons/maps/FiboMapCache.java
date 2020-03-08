package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    private boolean cacheOn = false;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
    }

    public BigDecimal fiboNumber(int n) {

        if (cacheOn && fiboCache != null){
            BigDecimal result = fiboCache.get(n);
            if (result != null){
                return result;
            }
        }
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = BigDecimal.ONE;
        BigDecimal x = BigDecimal.ONE;
        for (int i = 2; i <=n ; i++) {
            x = a.add(b);
            a = b;
            b = x;
        }
        if (cacheOn) {
            if (fiboCache == null) {
                fiboCache = new TreeMap<>();
            }
            fiboCache.put(n, x);
        }
        return x;
    }

    public void clearCahe() {
        fiboCache = null;
    }

    public static void test() {
        FiboMapCache f = new FiboMapCache(false);
        long st = System.currentTimeMillis();
        for (int i = 1; i <=1000 ; i++) {
            f.fiboNumber(i);
        }
        System.out.println(System.currentTimeMillis()-st);

        f.clearCahe();
        f = new FiboMapCache(true);
        st = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            f.fiboNumber(i);
        }
        System.out.println(System.currentTimeMillis()-st);

        f.clearCahe();
        f = new FiboMapCache(false);
        st = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            f.fiboNumber(i);
        }
        System.out.println(System.currentTimeMillis()-st);

        f = new FiboMapCache(true);
        f.clearCahe();

        st = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            f.fiboNumber(i);
        }
        System.out.println(System.currentTimeMillis()-st);
    }

    //1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,
    // 1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229
    public static void main(String[] args) {
        FiboMapCache.test();
       FiboMapCache f = new FiboMapCache(true);
        for (int i = 1; i < 30; i++) {
            System.out.print(f.fiboNumber(i) + ", ");
        }

        System.out.println();
        f = new FiboMapCache(false);
        for (int i = 1; i < 30; i++) {
            System.out.print(f.fiboNumber(i) + ", ");
        }
        System.out.println();

    }
}
