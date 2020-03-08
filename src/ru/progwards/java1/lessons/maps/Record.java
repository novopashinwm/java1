package ru.progwards.java1.lessons.maps;

public class Record {
    private String FIO;
    private String SKU;
    private int amount;
    private double sum;

    public Record(String FIO, String SKU, int amount, double sum) {
        this.FIO = FIO;
        this.SKU = SKU;
        this.amount = amount;
        this.sum = sum;
    }

    public String getFIO() {
        return FIO;
    }

    public String getSKU() {
        return SKU;
    }

    public int getAmount() {
        return amount;
    }

    public double getSum() {
        return sum;
    }
}
