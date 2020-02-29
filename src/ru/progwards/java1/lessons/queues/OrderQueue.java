package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> priorityQueue = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            int pr1 = getPriority(o1);
            int pr2 = getPriority(o2);
            if (pr1!=pr2){
                return Integer.compare(pr2,pr1);
            }
            return Double.compare(o2.getSum(), o1.getSum()) ;
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
        double[] arrD = new double[] {10860.0, 4972.0, 11092.0, 14961.0, 28601.0, 14112.0, 27732.0,
                18882.0, 27359.0, 18814.0, 26727.0, 9021.0, 27244.0,
                25308.0, 17677.0, 21591.0, 5501.0, 17750.0, 7537.0, 12229.0,
                18492.0, 23496.0, 15970.0, 15642.0};
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
