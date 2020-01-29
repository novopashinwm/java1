package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public final static double PId = 3.14;
    public final static float PIf  = 3.14f;
    public final static double Rd  = 6371.2;
    public final static float  Rf  = 6371.2f;

    public static double volumeBallDouble(double radius) {
        return 4.0 * PId * radius * radius * radius / 3.0;
    }

    public static float volumeBallFloat(float radius) {
        return 4.0f * PIf * radius * radius * radius / 3.0f;
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }

    public static void main(String[] args) {
        System.out.println("volumeBallDouble=" + volumeBallDouble(Rd));
        System.out.println("volumeBallFloat=" + volumeBallFloat(Rf));
        System.out.println("calculateAccuracy=" + calculateAccuracy(Rd));
    }
}
