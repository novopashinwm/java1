package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {


    public static String asNumbersSum(int number) {
        return number + divideIntoTerms(5, 1, "");
    }

    public static String divideIntoTerms(int number, int secondTerm, String lastTerm) {
        if(number == 1)
            return "";
        if(number/2 < secondTerm)
            return divideIntoTerms(number-1, 1, lastTerm + "+1");
        return " = " + (number-secondTerm) + "+" + secondTerm + lastTerm
                + divideIntoTerms(number, secondTerm+1, lastTerm);

    }
    public static void main(String[] args) {
        System.out.println(asNumbersSum(5));
    }
}
