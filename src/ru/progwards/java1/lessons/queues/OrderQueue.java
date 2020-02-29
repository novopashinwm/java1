package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> priorityQueue = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            int pr1 = getPriority(o1);
            int pr2 = getPriority(o2);
            if (pr1!=pr2) {
                Integer.compare(pr2,pr1);
            }
            return Integer.compare(o1.getNum(),o2.getNum());
        }
    });

    /*
    3 - заказы до 10000 руб включительно
2 - заказы от 10000 до 20000 руб включительно
1 - заказы от 20000 руб
    * */
    private int  getPriority(Order order) {
        if (order.getSum()<=100_000.00)
            return 1;
        if (order.getSum()>100_000.00 && order.getSum()<=200_000.00)
            return 2;
        return 3;
    }
    public void add(Order order) {
        priorityQueue.offer(order);
    }

    public Order get() {
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        double[] arrD = new double[] {17897.0, 22121.0,
                6118.0, 17190.0, 8859.0, 23732.0, 12643.0, 25460.0,
                4641.0, 16820.0, 17906.0, 3529.0, 27443.0, 9659.0, 11815.0,
                10449.0, 14564.0, 18596.0, 18801.0, 4057.0, 11889.0,
                12476.0, 8750.0, 15398.0};
        OrderQueue orderQueue = new OrderQueue();
        for (int i = 0; i < arrD.length; i++) {
            orderQueue.add(new Order(arrD[i]));
        }
        Order order = null;
        do {
            order = orderQueue.get();
            if (order !=null)
                System.out.print( order.getSum() + " " + order.getNum() + ", ");
        } while (order != null);
    }
}
