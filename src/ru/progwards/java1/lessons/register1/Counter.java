package ru.progwards.java1.lessons.register1;

public class Counter {

    public static void inc(ByteRegister value) {
        value = new ByteRegister((byte)(Integer.parseInt(value.toDecString())+1));
        System.out.println(value);
    }

    public static void dec(ByteRegister value) {
        value = new ByteRegister((byte)(Integer.parseInt(value.toDecString())-1));
        System.out.println(value);
    }

    public static void main(String[] args) {
        ByteRegister   byteRegister = new ByteRegister((byte)5);
        System.out.println(byteRegister);
        Counter.inc(byteRegister);
        System.out.println(byteRegister);
        Counter.dec(byteRegister);
        System.out.println(byteRegister);

    }
}
