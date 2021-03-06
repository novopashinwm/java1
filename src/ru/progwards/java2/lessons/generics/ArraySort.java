package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

/**
 * 2.1 Реализовать статический метод с именем sort, сортирующий произвольный массив обобщающих типов,
 * по алгоритму из первого урока:
 *
 * 1. Берем первый элемент и сравниваем его со вторым, если второй меньше, меняем элементы
 * в массиве местами.
 * 2. Далее, сравниваем первый элемент с третьим, и если третий меньше, меняем их местами.
 * 3. Так делаем для всех элементов с индексом больше первого
 * 4. Берем второй элемент и сравниваем его с третьим, если нужно, меняем местам
 * 5. Далее сравниваем второй элемент с четвертым, и если нужно, меняем местами.
 * 6. Делаем так для всех элементов, с индексом больше 2-го
 * 7. Переходим к элементу с индексом 3...
 * 8. Обобщая, алгоритм звучит следующим образом - сделать 2 вложенных цикла, внешний
 * по i и внутренний по j. Внутренний цикл начинается от i+1, и если a[i] > a[j],
 * то нужно поменять элементы a[i] и a[j] местами.
 * @param <T>
 */

public class ArraySort<T extends Comparable> {

    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ( arr[i].compareTo( arr[j]) >0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArraySort<Integer> m = new ArraySort<>();
        Integer[] arr = new Integer[] {3,7,4,2,1};
        m.sort(arr);
        System.out.println(Arrays.toString(arr));

        ArraySort<String> s = new ArraySort<>();
        String[] arrS = new String[] {"Jame", "Axe", "Bob", "Winsent"};
        s.sort(arrS);
        System.out.println(Arrays.toString(arrS));
    }
}
