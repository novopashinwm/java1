package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GoodsWithLambda {
    private List<Goods> list;
    public void setGoods(List<Goods> list)
    {
        this.list = list;
    }

    public List<Goods> sortByName(){
        return list.stream().sorted(Comparator.comparing(a->a.name)).collect(Collectors.toList());
    }

    public List<Goods> sortByNumber() {
        return list.stream().sorted(Comparator.comparing(a->a.number)).collect(Collectors.toList());
    }
    public List<Goods> sortByPartNumber() {
        return list.stream().sorted(Comparator.comparing(a->a.number.substring(0,3))).collect(Collectors.toList());
    }
    //List<Goods> sortByAvailabilityAndNumber() -
    // вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра

    public List<Goods> sortByAvailabilityAndNumber() {
        return list.stream().sorted(Comparator.comparing(a->a.available))
                .sorted(Comparator.comparing(a->a.number))
                .collect(Collectors.toList());
    }
    public List<Goods> expiredAfter(Instant date) {
        return list.stream().filter(a->a.expired.isAfter(date))
                .sorted(Comparator.comparing(a->a.expired))
                .collect(Collectors.toList());
    }

    public List<Goods> сountLess(int count) {
        return list.stream().filter(a->a.available < count).collect(Collectors.toList());
    }

    public List<Goods> сountBetween(int count1, int count2) {
        Predicate<Goods> greater = b -> b.available>=count1;
        Predicate<Goods> below = b -> b.available <= count2;
        Predicate<Goods> composed = below.and(greater);
        return list.stream().filter(composed).collect(Collectors.toList());
    }
}
