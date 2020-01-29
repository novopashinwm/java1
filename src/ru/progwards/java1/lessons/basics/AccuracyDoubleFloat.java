package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public final static double R  = 6371.2;


    public static double volumeBallDouble(double radius) {
        return (4.0/3.0) * 3.14 * radius * radius * radius ;
    }

    public static float volumeBallFloat(float radius) {
        return (float) ((4f/3f) * 3.14f * radius * radius * radius);
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float)radius);
    }

    public static void main(String[] args) {
        System.out.println("vd(1)=" + volumeBallDouble(1.0));
        System.out.println("vf(1)=" + volumeBallFloat(1.0f));
        System.out.println("volumeBallDouble=" + volumeBallDouble(R));
        System.out.println("volumeBallFloat=" + volumeBallFloat((float)R));
        System.out.println("calculateAccuracy=" + calculateAccuracy(R));
    }
}
