package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static boolean isTriangle(int a, int b, int c){
        return a < (b + c) && b < (c + a) && c < (a + b);
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return ((a * a + b * b) == c * c) || ((a * a + c * c) == b *b)
                || (( b * b + c * c) == a * a);
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return (a == b) || (b == c) || (a == c);
    }

    public static void main(String[] args) {
        System.out.println("isRightTriangle(4,3,5)=" + isRightTriangle(4,3,5));
    }
}
