package ru.progwards.java1.lessons.queues;

public class Order {
    private double sum;
    private static  int autonum =0 ;
    private  int num = 0;

    public Order(double sum) {
        Order.autonum++;
        num = Order.autonum;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }
}
