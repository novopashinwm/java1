package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) {
        return Integer.toString(number).contains(Integer.toString(digit));
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
            double min_side = TriangleSimpleInfo.minSide(a, b, c);
            double max_side = TriangleSimpleInfo.maxSide(a, b, c);
            double coeff = max_side / min_side;
            return coeff >= 1.61703 && coeff <= 1.61903;
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
    }
}
