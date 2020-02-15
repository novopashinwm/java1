package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) {
        try {
            FileReader fileReader = new FileReader(inFileName);
            FileWriter fileWriter = new FileWriter(outFileName);
            String lineRead =  "";
            String lineWrite = "";

            try {
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    lineRead = scanner.nextLine();
                    lineWrite = lineRead;
                    for (int i = 0; i < filter.length(); i++) {
                        lineWrite = lineWrite.replace(Character.toString(filter.charAt(i)),"");
                    }
                    fileWriter.write(lineWrite);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                fileReader.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        filterFile("test01.txt","test02.txt"," -,.()");
    }

    public static void CreateTestFile() {

    }
}
