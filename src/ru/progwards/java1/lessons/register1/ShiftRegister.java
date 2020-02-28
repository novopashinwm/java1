package ru.progwards.java1.lessons.register1;

public class ShiftRegister {
    public static void left(ByteRegister value) {
        ByteRegister v1 = new ByteRegister(Byte.parseByte(value.toDecString()));
        value.bitArr[value.bitArr.length-1] = value.b0;
        for (int i = value.bitArr.length-2; i >=0 ; i++) {
            value.bitArr[i] = v1.bitArr[i+1];
        }
    }

    public static void right(ByteRegister value) {
        ByteRegister v1 = new ByteRegister(Byte.parseByte(value.toDecString()));
        value.bitArr[0] = value.b0;
        for (int i = 1; i <value.bitArr.length ; i++) {
            value.bitArr[i] = v1.bitArr[i-1];
        }
    }
}
