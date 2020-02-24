package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    private List<Product> products;
    private List<Shop> shops;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> set = new HashSet<>();
        Iterator<Shop> it = shops.iterator();
        set.addAll(it.next().getProducts());
        for (; it.hasNext(); ) {
            set.retainAll(it.next().getProducts());
        }
        return set;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> set = new HashSet<>();
        for (Iterator<Shop> it = shops.iterator(); it.hasNext();) {
            set.addAll(it.next().getProducts());
        }
        return set;
    }

    public Set<Product> notExistInShops() {
        Set<Product> set = new HashSet<>(products);
        for (Iterator<Shop> it = shops.iterator(); it.hasNext();) {
            set.removeAll(it.next().getProducts());
        }
        return set;
    }

    public Set<Product> existOnlyInOne(){
        Set<Product> set = existAtListInOne();
        set.removeAll(existInAll());
        return set;
    }

    public static void main(String[] args) {
        Shop shop1 = new Shop(Arrays.asList(new Product("p01"), new Product("p02")));
        Shop shop2 = new Shop(Arrays.asList(new Product("p02"), new Product("p03")));
        ProductAnalytics pa = new ProductAnalytics(
                Arrays.asList(new Product("p01"), new Product("p02"), new Product("p14")
                , new Product("p03")), Arrays.asList(shop1, shop2));
        System.out.println(pa.existOnlyInOne());
    }
}
