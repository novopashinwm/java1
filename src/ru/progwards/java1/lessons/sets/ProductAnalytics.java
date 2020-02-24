package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Product> products;
    private List<Shop> shops;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> set = new HashSet<>();
        return set;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> set = new HashSet<>();
        return set;
    }

    public Set<Product> notExistInShops() {
        Set<Product> set = new HashSet<>();
        return set;
    }

    public Set<Product> existOnlyInOne(){
        Set<Product> set = new HashSet<>();
        return set;
    }
}
