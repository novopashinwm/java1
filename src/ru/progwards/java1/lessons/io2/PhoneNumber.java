package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone) {
        phone = phone.replaceAll("[^0-9]*","");
        if (phone.length()<10 || phone.length()>11) {
            throw new ArithmeticException("Цифр в телефонном номере должно быть 10 или 11!");
        }
        phone = phone.replaceFirst("8","+7");
        if (!phone.startsWith("+7")) {
            phone = "+7" + phone;
        }
        return phone.substring(0,2) + "(" + phone.substring(2,5) + ")"
                + phone.substring(5,8) + "-" + phone.substring(8);
    }

    public static void main(String[] args) {
        System.out.println(format("8(999)111-22-33"));
        System.out.println(format("8 999 111 22 33"));
    }
}
