package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    /**
     *
     * @param number - хоть задано трехзначное число, попытаюсь сделать универсальную функцию
     * @return
     */
    public static int reverseDigits(int number) {
        //Буду считать, что у меня только 3 значные числа
        int a = number / 100;
        int b = number / 10  % 10;
        int c = number % 10;
        return c * 100 + b * 10 + a;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(321));
        System.out.println(reverseDigits(421));
    }
}
