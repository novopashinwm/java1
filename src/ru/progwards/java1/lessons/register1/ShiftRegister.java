package ru.progwards.java1.lessons.register1;

public class ShiftRegister {
    public static void right(ByteRegister value) {

        ByteRegister v1 = new ByteRegister((byte) Integer.parseInt(value.toDecString()));
        value.bitArr[value.bitArr.length-1] = value.b0;
        for (int i = value.bitArr.length-2; i >=0 ; i--) {
            value.bitArr[i] = v1.bitArr[i+1];
        }
    }

    public static void left(ByteRegister value) {
        ByteRegister v1 = new ByteRegister(Byte.parseByte(value.toDecString()));
        value.bitArr[0] = value.b0;
        for (int i = 1; i <value.bitArr.length ; i++) {
            value.bitArr[i] = v1.bitArr[i-1];
        }
    }

    public static void main(String[] args) {
        int i = 1;
        i >>=1;
        System.out.println(i);
        ByteRegister byteRegister = new ByteRegister((byte)64);
        ShiftRegister.left(byteRegister);
        System.out.println(byteRegister.toDecString());
        ShiftRegister.right(byteRegister);
        System.out.println(byteRegister.toDecString());
    }
}
