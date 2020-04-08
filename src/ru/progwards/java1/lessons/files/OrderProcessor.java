package ru.progwards.java1.lessons.files;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessor {
    private String startPath;

    public OrderProcessor(String startPath)
    {

    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        return 1;
    }

    public List<Order> process(String shopId){
        return new ArrayList<>();
    }

    public Map<String, Double> statisticsByShop()
    {
        return new HashMap<>();
    }

    public Map<String, Double> statisticsByGoods()
    {
        return new HashMap<>();
    }
    public Map<LocalDate, Double> statisticsByDay() {
        return new HashMap<>();
    }
}
