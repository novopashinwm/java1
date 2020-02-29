package ru.progwards.java1.lessons.queues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        for (int i = 0; i < data.size() ; i++) {
            for (int j = i+1; j < data.size(); j++) {
                swap(((List<Integer>)data),i,j);
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
        while (data.size()!=0) {
            int min = Collections.min(data);
            list.add(min);
            data.remove(min);
        }
        Collections.copy((List<Integer>)data,list);
    }

    public static void collSort(Collection<Integer> data) {
        Collections.sort((List<Integer>)data);
    }

    public static Collection<String> compareSort() {
        return null;
    }
}
