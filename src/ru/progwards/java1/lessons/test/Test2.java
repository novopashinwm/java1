package ru.progwards.java1.lessons.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 5; i++)
            linkedList.add(i);
        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if (n % 2 != 0)
                listIterator.remove();
            else
                listIterator.add(n * 2);
        }
        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if (n % 2 != 0)
                listIterator.set(n * 2);
        }
    }

    public void iterator3(ListIterator<Integer> iterator) {
        for (;iterator.hasNext();) {
            Integer next = iterator.next();
            if (next % 3 == 0) {
                iterator.set(iterator.previousIndex());
            }
        }
    }


    public List<Integer> filter(List<Integer> list) {
        int sum = 0;
        List<Integer> remove = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        int p = sum/100;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).intValue()>=p) {
                remove.add(list.get(i));
            }
        }
        list.removeAll(remove);
        return list;
    }

    public List<Integer> listAction(List<Integer> list) {
        list.remove(Collections.min(list));
        list.add(0,list.size());
        list.add(2, Collections.max(list));
        return list;
    }

    public String setStars(String filename) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (int i = 9; i < raf.length(); i += 10) {
                raf.seek(i);
                sb.append( (char) raf.read());
                raf.seek(i);
                raf.write('*');
            }
        } catch (FileNotFoundException e) {
            sb.append(e.getClass().getName());
        }  catch (IOException e) {
            sb.append(e.getClass().getName());
        }
        return sb.toString();
    }

    String invertWords(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >=1 ; i--) {
            sb.append(arr[i]);
            sb.append(".");
        }
        sb.append(arr[0]);
        return sb.toString();
    }

    public void scanLines() {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        do {
            line = scanner.nextLine();
            if (line.toLowerCase().contains("привет"))
                System.out.println("Здравствуйте!");
            else if (line.toLowerCase().contains("как дела"))
                System.out.println("Хорошо");
            else if (line.equals("/stop")) {

            }
            else
                System.out.println(line);
        } while (!line.equalsIgnoreCase("/stop"));
    }
}
