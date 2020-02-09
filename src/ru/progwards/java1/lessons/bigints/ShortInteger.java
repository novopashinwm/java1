package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {

    public ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ShortInteger{" +
                "num=" + num +
                '}';
    }


    @Override
    public Number getNum() {
        return num;
    }
}
