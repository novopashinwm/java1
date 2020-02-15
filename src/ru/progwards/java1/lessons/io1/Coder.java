package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader fileReader = new FileReader(inFileName);
            FileWriter fileWriter = new FileWriter(outFileName);
            Scanner scanner = new Scanner(fileReader);
            String lineRead = "";
            String lineWrite = "";
            List<Character> list = new ArrayList<>();
            try {
                while (scanner.hasNext()) {
                    lineRead += scanner.nextLine();
                }
                lineWrite = lineRead;
                for (int i = 0; i < 255; i++) {
                    lineWrite = lineWrite.replace((char) i, code[i]);
                }

                System.out.println(Arrays.toString( list.toArray()));
                fileWriter.write(lineWrite);
            } catch (Exception e) {
                logName = e.getMessage();
            } finally {
                fileReader.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            logName = e.getMessage();
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[255];
        for (int i = 0; i < 255; i++) {
            arr[i] = (char) i;
        }
        arr[13] = 32;
        arr[32] = 13;
        Coder.codeFile("test01.txt", "test03.txt",arr, "");
    }
}
