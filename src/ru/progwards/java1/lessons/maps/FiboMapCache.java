package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    private boolean casheOn = false;
    private BigDecimal a = BigDecimal.ZERO;
    private BigDecimal b = BigDecimal.ONE;
    private BigDecimal x = null;

    public FiboMapCache(boolean cacheOn) {
        this.casheOn = cacheOn;
        if (casheOn) {
            fiboCache.put(0, a);
            fiboCache.put(1, b);
        }
    }

    public BigDecimal fiboNumber(int n) {
        BigDecimal ret = BigDecimal.ZERO;
        if (casheOn) {
            ret = fiboCache.get(n);
            if (ret != null) {
                return ret;
            }
        }

        int begin = 2;
        if (casheOn) {
            begin = fiboCache.size();
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

    public static void main(String[] args) {
        FiboMapCache.test();
    }
}
