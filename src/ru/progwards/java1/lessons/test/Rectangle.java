package ru.progwards.java1.lessons.test;

import java.util.Objects;

public class Rectangle {
    private double a;
    private double b;

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle rectangle = (Rectangle) anObject;
        return rectangle.area() == this.area();
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a*b;
    }

    public int compareTo(Rectangle anRectangle) {
        if (this.area()> anRectangle.area()) {
            return 1;
        } else if (this.area() < anRectangle.area()) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Rectangle(2.0,3.0).equals(new Rectangle(3.0,2.0)));
        System.out.println(new Rectangle(2.0,2.0).equals(new Rectangle(1.0,1.0)));
    }
}
