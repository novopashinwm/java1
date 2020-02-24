package ru.progwards.java1.lessons.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set setUnion = new HashSet(set1);
        setUnion.addAll(set2);
        return setUnion;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set result = new HashSet(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = SetOperations.union(set1,set2);
        result.removeAll(SetOperations.intersection(set1,set2));
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8));
        System.out.println(SetOperations.symDifference(set1,set2));
    }
}
