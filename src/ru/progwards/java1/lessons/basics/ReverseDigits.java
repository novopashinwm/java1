package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    /**
     *
     * @param number - хоть задано трехзначное число, попытаюсь сделать универсальную функцию
     * @return
     */
    public static int reverseDigits(int number) {
        StringBuilder sb = new StringBuilder(Integer.toString(number));
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(321));
        System.out.println(reverseDigits(4321));
    }
}
