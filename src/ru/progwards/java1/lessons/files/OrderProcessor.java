package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class OrderProcessor {
    private String startPath;
    private int failedFileNumber;
    private Map<String, List<Order>> ordersByShops; // key: shopId, value: ordersList

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
        this.failedFileNumber = 0;
        this.ordersByShops = new HashMap<>();
    }

    //    загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
//    Если start == null, значит нет ограничения по дате слева, если finish == null,
//    значит нет ограничения по дате справа, если shopId == null - грузим для всех магазинов
//    При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е. Не поступает в обработку.
//    Метод возвращает количество файлов с ошибками. При этом, если в классе содержалась информация, ее надо удалить
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {

        LocalDate startDate = (start == null) ? LocalDate.of(1970, 1, 1) : start;// Почему IDE требует создавать новую
        // переменную startDate и не позволяет использовать параметр start, передаваемый в функцию ???

        LocalDate finishDate = (finish == null) ? LocalDate.now() : finish; // Почему IDE требует создавать новую
        // переменную finishDate и не позволяет использовать параметр finish, передаваемый в функцию ???

        if (shopId == null)
            shopId = "";

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/" + shopId + "*.csv");
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(file)) {

                        LocalDateTime lastDateTime = LocalDateTime
                                .ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault());

                        if (LocalDate.from(lastDateTime).isBefore(startDate)
                                || LocalDate.from(lastDateTime).isAfter(finishDate)) {
                            return FileVisitResult.CONTINUE;
                        }

                        String fileName = file.getFileName().toString();
                        String[] idsArr = fileName.split("-");
                        if (idsArr.length != 3) {
                            failedFileNumber++;
                            return FileVisitResult.CONTINUE;
                        }
                        String shopId = idsArr[0];
                        String orderId = idsArr[1];
                        String customerId = idsArr[2].split("\\.")[0];
                        if (shopId.length() != 3
                                || orderId.length() != 6
                                || customerId.length() != 4) {
                            failedFileNumber++;
                            return FileVisitResult.CONTINUE;
                        }
                        Order order = new Order();
                        order.shopId = shopId;
                        order.orderId = orderId;
                        order.customerId = customerId;
                        order.datetime = lastDateTime;
                        order.items = new ArrayList<>();
                        order.sum = 0;

                        List<String> goods = Files.readAllLines(file);
                        for (String goodStr : goods
                        ) {
                            String[] strArr = goodStr.trim().split("\\s*,\\s*");

                            if (strArr.length != 3) {
                                failedFileNumber++;
                                return FileVisitResult.CONTINUE;
                            }

                            for (char ch : strArr[1].toCharArray()
                            ) {
                                if (!Character.isDigit(ch)) {
                                    failedFileNumber++;
                                    return FileVisitResult.CONTINUE;
                                }
                            }

                            int decimalSeparatorCounter = 0;
                            for (char ch : strArr[2].toCharArray()
                            ) {
                                if (Character.isDigit(ch))
                                    continue;

                                if (String.valueOf(ch).equals(".")) {
                                    decimalSeparatorCounter++;
                                    if (decimalSeparatorCounter > 1) {
                                        failedFileNumber++;
                                        return FileVisitResult.CONTINUE;
                                    }
                                } else {
                                    failedFileNumber++;
                                    return FileVisitResult.CONTINUE;
                                }
                            }

                            int goodsCount = Integer.parseInt(strArr[1]);
                            double oneGoodPrice = Double.parseDouble(strArr[2]);

                            OrderItem orderItem = new OrderItem();
                            orderItem.count = goodsCount;
                            orderItem.price = oneGoodPrice;
                            orderItem.googsName = strArr[0];

                            order.items.add(orderItem);
                            order.sum += (goodsCount * oneGoodPrice);
                        }
                        order.items.sort(new Comparator<OrderItem>() {
                            @Override
                            public int compare(OrderItem orderItem1, OrderItem orderItem2) {
                                return orderItem1.googsName.compareTo(orderItem2.googsName);
                            }
                        });

                        ordersByShops.putIfAbsent(order.shopId, new ArrayList<>());
                        ordersByShops.get(order.shopId).add(order);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return failedFileNumber;
    }

    public List<Order> process(String shopId) {
        List<Order> ordersList = new ArrayList<>();
        if (shopId == null) {
            for (List<Order> oneShopOrders : ordersByShops.values()
            ) {
                ordersList.addAll(oneShopOrders);
            }
        } else {
            if (ordersByShops.containsKey(shopId))
                ordersList.addAll(ordersByShops.get(shopId));
        }
        ordersList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        });
        return ordersList;
    }

    public Map<String, Double> statisticsByShop() {
        SortedMap<String, Double> statisticByShops = new TreeMap<>();
        for (String shopId : ordersByShops.keySet()
        ) {
            double sum = 0.0;
            for (Order order : ordersByShops.get(shopId)
            ) {
                sum += order.sum;
            }
            statisticByShops.put(shopId, sum);
        }
        return statisticByShops;
    }

    public Map<String, Double> statisticsByGoods() {
        SortedMap<String, Double> statisticByGoods = new TreeMap<>();
        for (String shopId : ordersByShops.keySet()
        ) {
            for (Order order : ordersByShops.get(shopId)
            ) {
                for (OrderItem orderItem : order.items
                ) {
                    statisticByGoods.putIfAbsent(orderItem.googsName, 0.0);
                    double sum = statisticByGoods.get(orderItem.googsName) + orderItem.price * (double) orderItem.count;
                    statisticByGoods.put(orderItem.googsName, sum);
                }
            }
        }
        return statisticByGoods;
    }

    public Map<LocalDate, Double> statisticsByDay() {
        SortedMap<LocalDate, Double> statisticByDays = new TreeMap<>();
        for (String shopId : ordersByShops.keySet()
        ) {
            for (Order order : ordersByShops.get(shopId)
            ) {
                LocalDate date = LocalDate.from(order.datetime);
                statisticByDays.putIfAbsent(date, 0.0);
                double sum = statisticByDays.get(date) + order.sum;
                statisticByDays.put(date, sum);
            }
        }
        return statisticByDays;
    }
}
