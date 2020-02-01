package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;
    private int N;

    public Eratosthenes(int N) {
        this.N = N;
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        for (int i = 2; i <  N; i++) {
            for (int j = i*2;  j <N; j +=i ) {
                sieve[j] = false;
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes e = new Eratosthenes(100);
        System.out.println(Arrays.toString(e.sieve));
        for (int i = 0; i < 100; i++) {
            if (e.isSimple(i)) {
                System.out.print( i +", ");
            }
        }
    }
}
