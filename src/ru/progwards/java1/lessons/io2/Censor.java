package ru.progwards.java1.lessons.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class CensorException extends RuntimeException {
    private String file;
    private String message;
    public CensorException(String message, String file) {
        super(message);
        this.message = message;
        this.file = file;
    }

    @Override
    public String toString() {
        return file + ":" + message;
    }
}

public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(inoutFileName)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new CensorException(inoutFileName,e.getMessage());
        } catch (IOException e) {
            throw new CensorException(inoutFileName,e.getMessage());
        }
        String read = sb.toString();
        for (int i = 0; i < obscene.length; i++) {
            char[] arr = new char[obscene[i].length()];
            Arrays.fill(arr,'*');
            read = read.replace(obscene[i],new String(arr));
        }
        try (FileWriter fileWriter = new FileWriter(inoutFileName)) {
            fileWriter.write(read);
        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }

    }

    public static void main(String[] args) {
        Censor.censorFile("test01.txt",
                new String[] {"Java", "Oracle", "Sun", "Microsystems"});
    }
}
