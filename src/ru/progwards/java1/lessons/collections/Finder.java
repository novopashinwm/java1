package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    //вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        int p1 = Integer.MAX_VALUE / 2, p2 = Integer.MAX_VALUE / 2;
        List<Integer> list = new ArrayList<>();
        return list;
    }

    //найти локальные максимумы - числа, которые больше соседа справа и слева.
    //Первый и последний элемент коллекции не может являться локальным  максимумом,
    // вернуть коллекцию, содержащую значения этих максимумов
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        return list;
    }

    //проверить, содержит ли коллекция все числа от 1 до size(),
    //порядок может быть произвольный
    public static boolean findSequence(Collection<Integer> numbers) {
        boolean ret = true;
        int i = 1;
        for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext(); i++) {
            Integer item = iterator.next();
            if (item != i) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    //найдите максимальное количество повторяющихся подряд элементов.
    //Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
    //При равенстве максимального количества у разных повторяющихся элементов,
    //вернуть результат для элемента, повторяющаяся последовательность
    //которого началась с наименьшего индекса.
    public static String findSimilar(Collection<String> names) {

        return "";
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 18; i++) {
            list.add(i);
        }
        System.out.println(Finder.findSequence( list));
    }

}
