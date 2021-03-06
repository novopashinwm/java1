package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BiDirList<T> {

    class ListItem<T> {

        private ListItem<T> next;
        private ListItem<T> prev;
        private T item;
        public ListItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        void setNext(ListItem<T> item) {
            next = item;
        }
        ListItem<T> getNext() {
            return next;
        }

        public ListItem<T> getPrev() {
            return prev;
        }

        public void setPrev(ListItem<T> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            String ret = "";
            if (prev!=null)
                ret = "prev=" + prev.getItem() +  ",";
            ret += "item=" + item;
            if (next!=null)
                ret += ", next=" + next.getItem();
            return ret ;
        }
    }

    private ListItem<T> head;
    private ListItem<T> tail;
    private int cnt = 0;

    public void addLast(T item){
        ListItem<T> node = new ListItem<T>(item);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        cnt++;
    }

    public void addFirst(T item) {
        ListItem<T> node = new ListItem<T>(item);
        ListItem<T> temp = head;
        node.setNext(temp);
        head = node;
        if (cnt ==0) {
            tail = head;
        } else {
            tail.setPrev(node);
        }
        cnt++;
    }

    ListItem<T> getHead() {
        return head;
    }

    ListItem<T> getTail() {
        return tail;
    }

    public void remove(T item) {
        ListItem<T> curr = getHead();
        while (curr.next!=null) {
            if (curr.getItem().equals(item)) {
                ListItem<T> prev = curr.getPrev();
                if(prev != null) {
                    prev.setNext(curr.getNext());
                }
                ListItem<T> next = curr.getNext();
                if(next != null) {
                    next.setPrev(curr.getPrev());
                }
                cnt--;
                return;
            }
            curr = curr.next;
        }
    }

    public T at(int i){
        if (i>=size()) {
            throw  new IndexOutOfBoundsException();
        }
        ListItem<T> curr = getHead();
        for (int j = 0; j < i; j++, curr= curr.next) {
        }
        return curr.getItem();
    }

    public int size() {
        return cnt;
    }
    public static<T> BiDirList<T> from(T[] array) {
        BiDirList<T> list = new BiDirList<>();
        for (int i = 0; i < array.length; i++) {
            list.addLast(array[i]);
        }
        return list;
    }

    public static<T> BiDirList<T> of(T...array) {
        return from(array);
    }

    public void toArray(T[] array) {
        int sizeOfList = size();
        if (array.length < sizeOfList) {
            array = (T[]) new Object[sizeOfList];
        }
        ListItem<T> elem = getHead();
        for(int i = 0; i < array.length; i++, elem = elem.getNext()) {
            if (elem == null) {
                array[i] = null;
            } else {
                array[i] = elem.getItem();
            }
        }
    }

    public Iterator<T> getIterator() {
        return new Iterator<T>() {
            private ListItem<T> currentListItem = getHead();
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                ListItem<T> listItemToReturn = currentListItem;
                currentListItem = currentListItem.getNext();
                index++;
                return listItemToReturn.getItem();
            }
        };
    }
    

    public static void main(String[] args) {
        BiDirList<Integer> list = new BiDirList<>();
        for(int i=0; i<100; i++) {
            list.addFirst(i);
            list.addLast(i);
        }
        Iterator<Integer> iter = list.getIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
