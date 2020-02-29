package ru.progwards.java1.lessons.queues;

import java.util.*;


public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        for (int i = 0; i < data.size() ; i++) {
            for (int j = i+1; j < data.size(); j++) {
                if (((List<Integer>)data).get(i)>((List<Integer>)data).get(j)) {
                    swap(((List<Integer>) data), i, j);
                }
            }
        }
    }

    private static void swap(List<Integer> list, int first, int second){
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    /*
    - создать новую коллекцию
- найти минимальный элемент с использованием функции min()
- переместить его в новую коллекцию
- делать так до тех пор, пока все элементы не окажутся в новой коллекции
- скопировать новую коллекцию в старую
    */
    public static void minSort(Collection<Integer> data) {
        List<Integer> list = new ArrayList<>();
        if (data == null) {
            return;
        }
        while (data.size()!=0) {
            int min = Collections.min(data);
            list.add(min);
            data.remove(min);
        }
        data.addAll(list);
    }

    public static void collSort(Collection<Integer> data) {
        Collections.sort((List<Integer>)data);
    }

    public static Collection<String> compareSort() {
        List<String> list = new ArrayList<>();
        list.add("collSort");
        list.add("minSort");
        list.add("mySort");
        return list;
    }


    public static void main(String[] args) {
        int N = 1_00000;
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            list.add(random.nextInt(1000));
        }
        List<Integer> listTest = new ArrayList<>();
        listTest.addAll(list);
        long date = new Date().getTime();
        CollectionsSort.mySort(listTest);
        System.out.println(new Date().getTime()-date);

        listTest.clear();
        listTest.addAll(list);
        date = new Date().getTime();
        CollectionsSort.minSort(listTest);
        System.out.println(new Date().getTime()-date);

        listTest.clear();
        listTest.addAll(list);
        date = new Date().getTime();
        CollectionsSort.collSort(listTest);
        System.out.println(new Date().getTime()-date);

    }
}
