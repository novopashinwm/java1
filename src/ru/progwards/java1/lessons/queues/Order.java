package ru.progwards.java1.lessons.queues;

public class Order {
    private double sum;
    private static int num = 0;

    public Order(double sum) {
        Order.num++;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return Order.num;
    }
}
