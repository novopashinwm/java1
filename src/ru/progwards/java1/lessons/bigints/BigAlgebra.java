package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    BigDecimal fastPow(BigDecimal num, int pow) {
        if (pow == 0) {
            return BigDecimal.ONE;
        }
        if ((pow & 1) != 0)
            return fastPow(num, pow - 1).multiply(num);
        num = fastPow(num, pow >> 1);
        return num.multiply(num);
    }

    BigInteger fibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger x = BigInteger.ZERO;
        for (int i = 2; i <=n ; i++) {
            x = a.add(b);
            a = b;
            b = x;
        }
        return x;
    }

    public static void main(String[] args) {
        BigAlgebra bigAlgebra = new BigAlgebra();
        System.out.println(bigAlgebra.fibonacci(6));
        System.out.println(bigAlgebra.fastPow(new BigDecimal("2"),71));
    }
}
