package ru.progwards.java1.lessons.register1;

public class Counter {

    public static void inc(ByteRegister value) {
        for (int i = 0; i < value.bitArr.length; i++) {
            if (value.bitArr[i].equals(value.b1)) {
                value.bitArr[i] = value.b0;
            } else {
                value.bitArr[i] = value.b1;
                break;
            }

        }
    }

    public static void dec(ByteRegister value) {
        for (int i = 0; i < value.bitArr.length; i++) {
            if (value.bitArr[i].equals( value.b0)) {
                value.bitArr[i] = value.b1;
            }  else {
                value.bitArr[i] = value.b0;
                break;
            }
        }
    }

    public static void main(String[] args) {
        ByteRegister   byteRegister = new ByteRegister((byte)-12);
        System.out.println(byteRegister);
        Counter.dec(byteRegister);
        System.out.println(byteRegister);
        Counter.inc(byteRegister);
        System.out.println(byteRegister);

    }
}
