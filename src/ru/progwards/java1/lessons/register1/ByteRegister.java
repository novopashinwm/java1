package ru.progwards.java1.lessons.register1;

public class ByteRegister {

    Bit[] bitArr = new Bit[8];
    public final Bit b1 = new Bit(true);
    public final Bit b0 = new Bit(false);

    public ByteRegister() {
        for (int i = 0; i < bitArr.length; i++) {
            bitArr[i] = new Bit(false);
        }
    }

    public ByteRegister(byte value) {
        int size = 7;
        if (value < 0) {
            bitArr[size] = new Bit(true);
            value &= 0x7F;
            size--;
        }

        for (int i=0; i<=size; i++) {
            bitArr[i] = new Bit((value & 1)==1);
            value >>= 1;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = bitArr.length-1; i>=0; i--) {
            sb.append(bitArr[i]);
        }
        return sb.toString();
    }

    public String toDecString() {
        int ret = 0;
        for (int i = 0, p = 1; i < bitArr.length; i++, p *=2) {
            if (bitArr[i].equals(new Bit(true))) {
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
