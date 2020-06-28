package ru.progwards.java2.lessons.trees;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class TreeTest {
    static final int ITERATIONS = 1000;
    public static void main(String[] args) throws TreeException {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        AvlTree<Integer, String> tree = new AvlTree<>();
        for(int i=0; i<ITERATIONS; i++) {
            int key = ThreadLocalRandom.current().nextInt();
            if (!map.containsKey(key)) {
                map.put(key, key);
                //tree.add(key, "key=" + key);
                tree.put(key,"key"+key);
            }
        }
        System.out.println("add passed OK");
        //tree.process(System.out::println);
        ArrayList<AvlTree.AvlLeaf> sorted = new ArrayList<>();
        tree.process(sorted::add);
        for(AvlTree.AvlLeaf leaf: sorted) {
            System.out.println(leaf.toString());
        }

        for(Integer i:map.keySet()) {
            tree.find(i);
            tree.delete(i);
        }
        System.out.println("find&delete passed OK");
    }
}

