package ru.progwards.java1.lessons.test;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");
    }

static Grade intToGrade(int grade) {
    switch (grade) {
        case 1: return Grade.VERYBAD;
        case 2: return Grade.BAD;
        case 3: return Grade.SATISFACTORILY;
        case 4: return Grade.GOOD;
        case 5: return Grade.EXCELLENT;
        default: return Grade.NOTDEFINED;
    }
}

    public int arrayMax(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        Arrays.sort(a);
        return a[a.length-1];
    }

    public int sumArrayItems(int[] a) {
        int sum = 0 ;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
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
