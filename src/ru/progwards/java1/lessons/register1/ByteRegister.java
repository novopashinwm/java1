package ru.progwards.java1.lessons.register1;

public class ByteRegister {

    Bit[] arr = new Bit[8];

    public ByteRegister() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Bit(false);
        }
    }

    public ByteRegister(byte value) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public String toDecString() {
        int ret = 0;
        int p = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("1")) {
                ret += p;
            }
            p *= 2;
        }
        return Integer.toString(ret);
    }
}
