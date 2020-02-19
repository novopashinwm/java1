package ru.progwards.java1.lessons.register1;

public class ByteRegister {

    Bit[] arr = new Bit[8];

    public ByteRegister() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Bit(false);
        }
    }

    public ByteRegister(byte value) {
        int size = 7;
        if (value < 0) {
            arr[size] = new Bit(true);
            value &= 0x7F;
            size--;
        }

        for (int i=0; i<=size; i++) {
            arr[i] = new Bit((value & 1)==1);
            value >>= 1;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public String toDecString() {
        int ret = 0;
        for (int i = 0, p =1 ; i < arr.length; i++, p *=2) {
            if (arr[i].equals(new Bit(true))) {
                ret += p;
            }
        }
        return Integer.toString(ret);
    }

    public static void main(String[] args) {
        ByteRegister b = new ByteRegister((byte)17);
        System.out.println(b);
        System.out.println(b.toDecString());
    }
}
