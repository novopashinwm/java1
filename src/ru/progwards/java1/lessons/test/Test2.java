package ru.progwards.java1.lessons.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.setStars("test05.txt"));
    }

    public String setStars(String filename) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (int i = 9; i < raf.length(); i += 10) {
                raf.seek(i);
                sb.append( (char) raf.read());
                raf.seek(i);
                raf.write('*');
            }
        } catch (FileNotFoundException e) {
            sb.append(e.getClass().getName());
        }  catch (IOException e) {
            sb.append(e.getClass().getName());
        }
        return sb.toString();
    }

    String invertWords(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >=1 ; i--) {
            sb.append(arr[i]);
            sb.append(".");
        }
        sb.append(arr[0]);
        return sb.toString();
    }

    public void scanLines() {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        do {
            line = scanner.nextLine();
            if (line.toLowerCase().contains("привет"))
                System.out.println("Здравствуйте!");
            else if (line.toLowerCase().contains("как дела"))
                System.out.println("Хорошо");
            else if (line.equals("/stop")) {

            }
            else
                System.out.println(line);
        } while (!line.equalsIgnoreCase("/stop"));
    }
}
