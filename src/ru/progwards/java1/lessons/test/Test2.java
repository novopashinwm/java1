package ru.progwards.java1.lessons.test;

public class Test2 {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.toString());
        }
        catch (NullPointerException npe) {
            System.out.println("catch-npe");
        }
        catch (Exception e) {
            System.out.println("catch");
        }
    }
}
