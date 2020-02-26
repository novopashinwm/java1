package ru.progwards.java1.lessons.sets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.TreeSet;

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        try (Reader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                char[] arrCh = scanner.next().toCharArray();
                for (int i = 0; i < arrCh.length; i++) {
                    set.add(arrCh[i]);
                }
            }
        } catch (IOException e) {
            throw e;
        }

        return set.toString();
    }

    public static void main(String[] args) {
        try {
            process("test02.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
