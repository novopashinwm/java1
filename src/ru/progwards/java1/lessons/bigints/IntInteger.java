package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {

    public IntInteger(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "IntInteger{" +
                "num=" + num +
                '}';
    }

    @Override
    public Number getNum() {
        return num;
    }
}
