package ru.progwards.java1.lessons.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene) {
        try (FileReader fileReader = new FileReader(inoutFileName)) {

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    class CensorException extends RuntimeException {
        private String file;
        public CensorException(String ex, String file) {
            super(ex);
            this.file = file;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    public static void main(String[] args) {
        Censor.censorFile("text01.txt",
                new String[] {"Java", "Oracle", "Sun", "Microsystems"});
    }




}
