package ru.progwards.java1.lessons.test;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");
    }
    static int addAsStrings(int n1, int n2) {
        return Integer.parseInt(Integer.toString(n1) + Integer.toString(n2));
    }

    static String textGrade(int grade) {
        if (grade == 0) {
            return "не оценено";
        } else if (grade >= 1 && grade <= 20) {
            return "очень плохо";
        } else if (grade >= 21 && grade <= 40) {
            return "плохо";
        } else if (grade >= 41 && grade <= 60) {
            return "удовлетворительно";
        } else if (grade >= 61 && grade <= 80) {
            return "хорошо";
        } else if (grade >= 81 && grade <= 100) {
            return "отлично";
        }
        return "не определено";
    }

    static long factorial(long n) {
        if (n == 0) {
            return 1L;
        }
        return n * factorial(n-1);
    }
}
