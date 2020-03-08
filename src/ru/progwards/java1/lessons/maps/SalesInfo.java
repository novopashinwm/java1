package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class SalesInfo {
    StringBuilder sb = new StringBuilder();
    List<Record> records = new ArrayList<>();

    public int loadOrders(String fileName) {
        int cnt = 0;
        try (Reader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] arrS = line.split("\\,");
                if (arrS.length==4  && arrS[2].trim().matches("^[0-9\\.]+$")
                      &&  arrS[3].trim().matches("^[0-9]+$")  ) {
                    records.add(getRecord(line));
                    cnt++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    private Record getRecord(String line) {
        String[] arrS = line.split(",");
        String FIO = arrS[0].trim();
        String SKU = arrS[1].trim();
        int amount = Integer.parseInt(arrS[2].trim());
        double sum = Double.parseDouble(arrS[3].trim());
        return new Record(FIO, SKU, amount, sum);
    }

    public Map<String, Double> getGoods() {
        TreeMap<String, Double> map = new TreeMap<>();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            map.put(record.getSKU(),record.getSum());
        }
        return map;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> map = new TreeMap<>();
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            int amount = record.getAmount();
            double sum = record.getSum();
            if (map.containsKey(record.getFIO())) {
                AbstractMap.SimpleEntry<Double, Integer> simpleEntry = map.get(record.getFIO());
                sum += simpleEntry.getKey();
                amount += simpleEntry.getValue();
            }
            map.put(record.getFIO(), new AbstractMap.SimpleEntry<Double, Integer>(sum,amount));
        }
        return map;
    }

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("text10.txt"));
        System.out.println(salesInfo.getGoods());
        System.out.println(salesInfo.getCustomers());
    }
}
