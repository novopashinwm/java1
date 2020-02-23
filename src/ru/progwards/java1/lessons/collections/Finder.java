package ru.progwards.java1.lessons.collections;

import java.util.Collection;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    //вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        int p1 = Integer.MAX_VALUE / 2, p2 = Integer.MAX_VALUE / 2;
        return null;
    }

    //найти локальные максимумы - числа, которые больше соседа справа и слева.
    //Первый и последний элемент коллекции не может являться локальным  максимумом,
    // вернуть коллекцию, содержащую значения этих максимумов
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        return null;
    }

    //проверить, содержит ли коллекция все числа от 1 до size(),
    //порядок может быть произвольный
    public static boolean findSequence(Collection<Integer> numbers) {
        return false;
    }

    //найдите максимальное количество повторяющихся подряд элементов.
    //Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
    //При равенстве максимального количества у разных повторяющихся элементов,
    //вернуть результат для элемента, повторяющаяся последовательность
    //которого началась с наименьшего индекса.
    public static String findSimilar(Collection<String> names) {
        return null;
    }

}
