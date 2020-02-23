package ru.progwards.java1.lessons.collections;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    //вернуть коллекцию, содержащую индексы этих чисел
    //возвращает неверную коллекцию.
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        int p1 = Integer.MAX_VALUE / 2, p2 = Integer.MAX_VALUE / 2;
        int i1 = 0, i2 = 0;

        int[] arrNum = new int[numbers.size()];
        Object[] arr = numbers.toArray();
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = (int)arr[i];
        }

        for (int i = 0; i < arrNum.length-1; i++) {
            if ( (arrNum[i] + arrNum[i+1]) < (p1 + p2)) {
                p1 = arrNum[i];
                p2 = arrNum[i+1];
                i1 = i;
                i2 = i + 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        return list;
    }

    //найти локальные максимумы - числа, которые больше соседа справа и слева.
    //Первый и последний элемент коллекции не может являться локальным  максимумом,
    // вернуть коллекцию, содержащую значения этих максимумов

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {

        int max = Integer.MIN_VALUE;
        int[] arrNum = new int[numbers.size()];
        Object[] arr = numbers.toArray();
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = (int)arr[i];
        }

        for (int i = 1; i < arrNum.length -1 ; i++) {
            if (arrNum[i-1] < arrNum[i] && arrNum[i] > arrNum[i+1] ) {
                max = Math.max(max, arrNum[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(max);
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
        int max =0, cnt = 1;
        String item = "", max_item="", prev = "";
        Iterator<String> iter = names.iterator();
        item = iter.next();
        prev = item;
        for (;iter.hasNext();) {
            item = iter.next();
            if (item.equals(prev)) {
                cnt++;
                if (cnt > max) {
                    max = cnt ;
                    max_item = item;
                }
            }  else {
                cnt = 1;
            }
            prev = item;
        }

        return max_item + ":" + max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //-69,-95,-79,84,-32,-47,34
        int[] arr = new int[] {54,-17,-70,-5,40,61,-33};
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        String[] arrS = new String[] {"Борис","Борис","Григорий","Дмитрий","Борис"
                ,"Александр","Дмитрий","Григорий","Дмитрий","Борис","Александр"
                ,"Борис","Василий","Василий","Василий","Александр"};
        List<String> listS = new ArrayList<>();
        for (int i = 0; i < arrS.length; i++) {
            listS.add(arrS[i]);
        }
        System.out.println(Finder.findSimilar( listS));
    }

}
