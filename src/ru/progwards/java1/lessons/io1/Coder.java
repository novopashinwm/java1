package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader fileReader = new FileReader(inFileName);
            FileWriter fileWriter = new FileWriter(outFileName);

            StringBuilder sb = new StringBuilder();
            try {
                int symbol = fileReader.read();
                while (symbol != -1) {
                    fileWriter.write(code[symbol]);
                    symbol = fileReader.read();
                }
            } catch (Exception e) {
                FileWriter logFile = new FileWriter(logName);
                logFile.write(e.getMessage());
                logFile.close();
            } finally {
                fileReader.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            try {
                FileWriter logFile2 = new FileWriter(logName);
                logFile2.write(e.getMessage());
                logFile2.close();
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[255];
        for (int i = 0; i < 255; i++) {
            arr[i] = (char) i;
        }
        arr[13] = 32;
        arr[32] = 13;
        Coder.codeFile("test01.txt", "test03.txt",arr, "log_name");
    }
}
