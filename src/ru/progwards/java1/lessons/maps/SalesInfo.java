package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class SalesInfo {
    StringBuilder sb = new StringBuilder();

    public int loadOrders(String fileName) {
        int cnt = 0;
        try (Reader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] arrS = line.split("\\,");
                if (arrS.length==4  && arrS[3].trim().matches("^[0-9]+$")  ) {
                    sb.append(line + "\n");
                    cnt++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cnt;
    }
    public Map<String, Double> getGoods() {
        TreeMap<String, Double> map = new TreeMap<>();
        String[] arrS = sb.toString().split("\n");
        for (int i = 0; i < arrS.length; i++) {
            String[] item = arrS[i].split("\\,");
            if (map.containsKey(item[1].trim())) {
                map.put(item[1].trim(), map.get(item[1].trim()) +
                        Double.parseDouble(item[2].trim()) * Integer.parseInt(item[3].trim()));
            }
            else {
                map.put(item[1].trim(), Double.parseDouble(item[2].trim()) * Integer.parseInt(item[3].trim()));
            }
        }
        return map;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> map = new TreeMap<>();
        String[] arrS = sb.toString().split("\n");
        for (int i = 0; i < arrS.length; i++) {
            String[] item = arrS[i].split("\\,");
            if (map.containsKey(item[1].trim())) {
                Map<Double, Integer>  m = new HashMap<>();
                m.put(Double.parseDouble(item[2].trim()) , Integer.parseInt(item[3].trim()));

            }
        }
        return map;
    }

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("test07.txt"));
        System.out.println(salesInfo.getGoods());
    }
}
