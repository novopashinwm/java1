package ru.progwards.java1.lessons.test;

import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));

        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();

        System.out.println(wordSet.size());


    }

    public Set<Integer> a2set(int[] a) {

        Set<Integer> set  = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        return set;
    }

    public Integer sqr(Integer n) {
        try {
            return n.intValue() * n.intValue();
        }
        catch (NullPointerException e) {
            return -1;
        }
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

    public String test(String filename) throws IOException {
        if (filename == null) {
            throw new IOException("File not found");
        }
        return "File processing";
    }

    private int lineCount(String filename) throws IOException {
        try {
            FileReader  fileReader = new FileReader(filename);
            Scanner scanner = new Scanner(fileReader);
            int cnt = 0;
            try {
               while (scanner.hasNext()) {
                   cnt++;
                   scanner.nextLine();
               }
            } finally {
                fileReader.close();

            }
            return cnt;
        } catch (IOException e) {
            throw new IOException("файл не найден");
        }
    }

    public void doSomething(int n) throws IOException {

    }

    /*
    Существует метод public void doSomething(int n) throws IOException,
     создайте свой метод, с сигнатурой public void test(int n), который должен содержать блоки try-catch-finally

    1) В блоке try вызовите метод doSomething(n)
    2) В блоке catch выведите на консоль строку, полученную из исключения через  getMessage()
    3) Пробросите исключение дальше
    4) В блоке finally выведите на консоль фиксированный текст "finally executed"
    * */

    public  void  test (int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw  e;
        }
        finally {
            System.out.println("finally executed");
        }
    }
}
