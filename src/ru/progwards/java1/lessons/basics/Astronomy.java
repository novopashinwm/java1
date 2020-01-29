package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public final static double PI = 3.14;

    public static Double sphereSquare(Double r) {
        return 4 * PI * r * r;
    }

    public static Double earthSquare() {
        return sphereSquare(6371.2);
    }

    public static Double mercurySquare() {
        return sphereSquare(2439.7);
    }

    public static Double jupiterSquare() {
        return sphereSquare(71492.0);
    }

    public static Double earthVsMercury() {
        return earthSquare()/mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare()/jupiterSquare();
    }

    public static void main(String[] args) {
        System.out.println("earthSquare=" + earthSquare());
        System.out.println("mercurySquare=" + mercurySquare());
        System.out.println("jupiterSquare=" + jupiterSquare());
        System.out.println("earthVsMercury=" + earthVsMercury());
        System.out.println("earthVsJupiter=" + earthVsJupiter());
    }
}
