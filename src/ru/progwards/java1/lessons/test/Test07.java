package ru.progwards.java1.lessons.test;

import java.util.*;

public class Test07 {

    static class Person {
        public String name;
        public Date birth;
        public double salary;

        Person(String name, Date birth, double salary) {
            this.name = name;
            this.birth = birth;
            this. salary = salary;
        }
    }

    void printPersons(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            System.out.format(new Locale("ru"),"|%-10s|%td/%tm/%tY|%,10.2f|",persons[i].name,
                    persons[i].birth, persons[i].birth,
                    persons[i].birth,persons[i].salary);
            System.out.println();
        }

    }
    public static void main(String[] args) {
        System.out.format("|%04d|%#x|%2.1f|", 2, 15, 3.25);
        System.out.println();
        String txt =
                "StringTokenizer - этот класс, " +
                        "нам строку разобьёт на раз.";
        StringTokenizer tokenizer = new StringTokenizer(txt, " .,");
        while (tokenizer.hasMoreTokens())
            System.out.print(tokenizer.nextToken());
        System.out.println();
        Test07 test = new Test07();
        System.out.println(test.swapWords("Слово - серебро, молчание - золото!"));

        Person[] arr = new Person[1];
        arr[0] = new Person("Вася", new Date(1970,0,1),200_000.0);
        test.printPersons(arr);

    }

    String swapWords(String sentance) {
        StringTokenizer tokenizer = new StringTokenizer(sentance," .,-!\n");
        //Слово - серебро, молчание - золото!
        String sRet ="";
        while (tokenizer.hasMoreTokens()) {
            String a = "" ,b = "";
            if (tokenizer.hasMoreTokens())
                a = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens())
                b = tokenizer.nextToken();
            if (!b.equals(""))
                sRet += " " + b;
            if (!a.equals(""))
                sRet += " " + a;
        }

        sRet = sRet.substring(1);
        return sRet;
    }
}
