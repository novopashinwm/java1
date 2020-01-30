package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) {
        while (number > 0) {
            if (abs(number % 10) == abs(digit)) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
    public static int abs( int number) {
        if (number < 0)
            return number * -1;
        return number;
    }
    public static int fiboNumber(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if(TriangleInfo.isIsoscelesTriangle(a, b, c)) {
            double min_side = (double) TriangleSimpleInfo.minSide(a, b, c);
            double max_side = (double) TriangleSimpleInfo.maxSide(a, b, c);
            double coeff = max_side / min_side;
            if ((a==max_side && b == max_side) || (a == max_side && c == max_side) ||
                    (b == max_side && c == max_side)) {
                return coeff > 1.61703 && coeff < 1.61903;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " " + fiboNumber(i));
        }

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    if (isGoldenTriangle(a, b, c)) {
                        System.out.println("a=" + a +", b=" + b + ", c=" +c);
                    }
                }
            }
        }
        System.out.println("containsDigit(123456,1) =" +containsDigit(123456,1));
        System.out.println("containsDigit(123456,2) =" +containsDigit(123456,2));
        System.out.println("containsDigit(123456,3) =" +containsDigit(123456,3));
        System.out.println("containsDigit(123456,4) =" +containsDigit(123456,4));
        System.out.println("containsDigit(123456,5) =" +containsDigit(123456,5));
        System.out.println("containsDigit(123456,6) =" +containsDigit(123456,6));
        System.out.println("containsDigit(123456,7) =" +containsDigit(123456,7));
        System.out.println("containsDigit(123456,8) =" +containsDigit(123456,8));



    }
}
