package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = null;
    private boolean casheOn = false;
    private BigDecimal a = BigDecimal.ZERO;
    private BigDecimal b = BigDecimal.ONE;
    private BigDecimal x = null;
    private BigDecimal ret = BigDecimal.ZERO;

    public FiboMapCache(boolean cacheOn) {
        this.casheOn = cacheOn;
        if (casheOn) {
            InitCache();
        }
    }

    public BigDecimal fiboNumber(int n) {

        int begin = 2;

        if (casheOn) {
            if (fiboCache == null) {
                InitCache();
            }
            ret = fiboCache.get(n);
            if (ret != null) {
                return ret;
            }
            begin = fiboCache.size();
        }

        if (!casheOn)  {
            a = BigDecimal.ZERO;
            b = BigDecimal.ONE;
            ret = BigDecimal.ONE;
        }

        for (int i = begin; i <=n ; i++) {
            if (casheOn &&  (x = fiboCache.get(i))!= null) {
                a = fiboCache.get(i-2);
                b = fiboCache.get(i-1);
                ret = x;
            } else {

                ret = a.add(b);
                if (casheOn) {
                    fiboCache.put(i, ret);
                }
            }
            a = b;
            b = ret;
        }
        return ret;
    }

    public void clearCahe() {
        fiboCache = null;

    }

    private void InitCache() {
        fiboCache = new HashMap<>();
        a = BigDecimal.ZERO;
        b = BigDecimal.ONE;
        fiboCache.put(0, a);
        fiboCache.put(1, b);
        ret = BigDecimal.ZERO;
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
    }

    //1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,
    // 1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229
    public static void main(String[] args) {
       FiboMapCache f = new FiboMapCache(true);
        for (int i = 1; i < 30; i++) {
            System.out.print(f.fiboNumber(i)+", ");
        }
        f.clearCahe();
        System.out.println();
        for (int i = 1; i < 30; i++) {
            System.out.print(f.fiboNumber(i)+", ");
        }

    }
}
