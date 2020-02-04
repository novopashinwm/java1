package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
        if (n == getLastFibo().n) {
            return getLastFibo().fibo;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        lastFibo.n = n;
        lastFibo.fibo = c;
        return c;
    }
    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static CacheInfo getLastFibo() {
        if (lastFibo==null) {
            lastFibo = new CacheInfo();
        }
        return lastFibo;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }
}
