package ru.progwards.java1.lessons.test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /*System.out.println("Сделаю коммит, запушу в репо: робот, проверяй теперь всё это...");
        PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        };
        System.out.println();
        Test1 t = new Test1();
        String[] content = new String[] {"01","02", "03"};
        try {
            FileWriter fw = new FileWriter("test01.txt");
            for (int i = 0; i < content.length; i++) {
                fw.write(content[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {

        }*/
        Test1 t = new Test1();
        try {

            System.out.println(t.lineCount("test01.txt"));
        } catch (IOException e) {}

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
}
