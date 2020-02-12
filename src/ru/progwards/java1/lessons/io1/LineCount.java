package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int cnt = 0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

                try {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if (line.trim().equals("")) {
                            cnt++;
                        }
                    }
                } catch (Exception e) {
                    return -1;
                } finally {
                    reader.close();
                }

        } catch (IOException e) {
            return -1;
        }
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(calcEmpty("test01.txt"));
    }

}
