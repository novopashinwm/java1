package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsageFrequency {
    StringBuilder sb = new StringBuilder();
    public void processFile(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Character, Integer> getLetters() {
        char[] arrChar = sb.toString().toCharArray();
        HashMap<Character, Integer> ret = new HashMap<>();
        for (int i = 0; i < arrChar.length; i++) {
            if (!Character.isAlphabetic(arrChar[i]) && !Character.isDigit(arrChar[i]) ) {
                continue;
            }
            if (!ret.containsKey(arrChar[i])) {
                ret.put(arrChar[i],1);
            } else  {
                ret.put(arrChar[i], ret.get(arrChar[i])+1);
            }
        }
        return ret;
    }

    public Map<String, Integer> getWords() {
        String[] arrS = sb.toString().split("[\\s\".,!?@=;\\-+/*:()\\[\\]<>'–]+");

        TreeMap<String, Integer> ret = new TreeMap<>();
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i].equals("") ) {
                continue;
            }
            if (!ret.containsKey(arrS[i])) {
                ret.put(arrS[i], 1);
            } else {
                ret.put(arrS[i], ret.get(arrS[i]) + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        UsageFrequency usageFrequency = new UsageFrequency();
        usageFrequency.processFile("test05.txt");
        System.out.println(usageFrequency.getLetters());
        System.out.println(usageFrequency.getWords());
    }
}
