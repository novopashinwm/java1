package ru.progwards.java2.lessons.recursion;

import java.util.Arrays;

public class HanoiTower {
    private boolean onTrace = false;
    private String empty = "  I  ";
    private String[] arrA;
    private String[] arrB;
    private String[] arrC;
    private int size, pos;

    public HanoiTower(int size, int pos)
    {
        this.size = size;
        this.pos = pos;
        arrA = new String[size];
        arrB = new String[size];
        arrC = new String[size];
        Arrays.fill(arrA, empty);
        Arrays.fill(arrB, empty);
        Arrays.fill(arrC, empty);
        switch (pos){
            case 0: InitTower(arrA); break;
            case 1: InitTower(arrB); break;
            case 2: InitTower(arrC); break;
        }
        onTrace = false;
    }

    private void InitTower(String[] tower) {
        for (int i = 0; i < size; i++) {
            tower[i] ="<00"+(i+1) +">";
        }
    }

    public void move(int from, int to)
    {
        int additional = Integer.parseInt("012".replaceAll("" + from, "")
                .replaceAll("" + to, ""));
        hanoi(size, from, to, additional);
    }

    void hanoi(int n, int from, int to, int additional) {

        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, additional, to);
        System.out.println(from + " " + to);
        if (onTrace) {
            print();
        }
        hanoi(n - 1, additional, to, from);
    }

    void print()
    {
        System.out.println(this);
    }

    void setTrace(boolean onTrace) {
        this.onTrace = onTrace;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrA[i] + " " + arrB[i] + " " + arrC[i] +"\n");
        }
        sb.append("----------------\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        HanoiTower tower = new HanoiTower(3,2);
        tower.setTrace(true);
        tower.print();
        tower.move(2,1);
        tower.print();
    }

}
