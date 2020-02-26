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
        Set<Product> set = new HashSet<>();
        for (Iterator<Shop> it = shops.iterator(); it.hasNext();) {
            for (Iterator<Product> p = it.next().getProducts().iterator(); p.hasNext() ; ) {
                Product product = p.next();
                if (!set.contains(product))
                    set.add(product);
                else
                    set.remove(product);
            }
        }
        return set;
    }

    public static List<Product> getListProductfromArray(String[] arr) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Product(arr[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        String[] prShop1 = new String[] { "art-2" , "art-4" ,"art-7" };
        String[] prShop2 = new String[] { "art-1" , "art-5" , "art-10" };
        String[] prShop3 = new String[] { "art-1" , "art-4" ,"art-5" , "art-9" , "art-10"};
        String[] prProds = new String[] { "art-1" , "art-2" , "art-3" ,"art-4" , "art-5"
                , "art-6" ,"art-7" , "art-8" , "art-9" , "art-10"};

        Shop shop1 = new Shop(getListProductfromArray(prShop1));
        Shop shop2 = new Shop(getListProductfromArray(prShop2));
        Shop shop3 = new Shop(getListProductfromArray(prShop3));
        ProductAnalytics pa = new ProductAnalytics(
                getListProductfromArray(prProds), Arrays.asList(shop1, shop2, shop3));
        System.out.println(pa.existOnlyInOne());
    }
}
