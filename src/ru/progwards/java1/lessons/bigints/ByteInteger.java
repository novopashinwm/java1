package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {

    public ByteInteger(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ByteInteger{" +
                "num=" + num +
                '}';
    }

    @Override
    public Number getNum() {
        return num;
    }
}
