package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c) {
        return max(max(a,b),c);
    }

    public static int minSide(int a, int b, int c) {
        return min(min(a,b),c);
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return a==b && b==c && a == c;
    }

    static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static int min (int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("maxSide(1,2,3)=" + maxSide(1,2,3));
        System.out.println("maxSide(2,1,3)=" + maxSide(2,1,3));
        System.out.println("maxSide(3,2,1)=" + maxSide(3,2,1));

        System.out.println("minSide(1,2,3)=" + minSide(1,2,3));
        System.out.println("minSide(2,1,3)=" + minSide(2,1,3));
        System.out.println("minSide(3,2,1)=" + minSide(3,2,1));
    }
}
