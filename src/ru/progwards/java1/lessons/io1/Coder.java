package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader fileReader = new FileReader(inFileName);
            FileWriter fileWriter = new FileWriter(outFileName);
            Scanner scanner = new Scanner(fileReader);
            String lineRead = "";
            String lineWrite = "";
            try {
                while (scanner.hasNext()) {
                    lineRead += scanner.next();
                }

                for (int i = 0; i < code.length; i++) {
                    lineWrite += code[(int)lineRead.charAt(i)];
                }
                fileWriter.write(lineWrite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                fileReader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
