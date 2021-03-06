package ru.progwards.java2.lessons.tests.calc;

public class SimpleCalculator {
    public static int sum(int val1, int val2) {
        long r1 = (long) val1 + val2;
        if (r1 > Integer.MAX_VALUE || r1 < Integer.MIN_VALUE)
            throw new ArithmeticException("integer overflow");
        return (int) r1;
    }

    public static int diff(int val1, int val2) {
        long r1 = (long) val1 - val2;
        if (r1 > Integer.MAX_VALUE || r1 < Integer.MIN_VALUE)
            throw new ArithmeticException("integer overflow");
        return (int) r1;
    }

    public static int mult(int val1, int val2) {
        long r1 = (long) val1 * val2;
        if (r1 > Integer.MAX_VALUE || r1 < Integer.MIN_VALUE)
            throw new ArithmeticException("integer overflow");
        return (int) r1;
    }

    public static int div(int val1, int val2) {
        if (val2 == 0) throw new ArithmeticException("division by zero");
        long r1 = (long) val1 / val2;

        return (int) r1;
    }
}
