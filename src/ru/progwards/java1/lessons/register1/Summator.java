package ru.progwards.java1.lessons.register1;

public class Summator {
    public static boolean add(ByteRegister value1, ByteRegister value2) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (value1.bitArr[i].equals(value1.b0) && value2.bitArr[i].equals(value2.b1)) {
                value1.bitArr[i] = value1.b1;
                if (count>0) {
                    count++;
                    value1.bitArr[i] = value1.b0;
                }
            } else if (value1.bitArr[i].equals(value1.b1) && value2.bitArr[i].equals(value2.b1)) {
                value1.bitArr[i] = value1.b0;
                if (count>0) {
                    count--;
                    value1.bitArr[i] = value1.b1;
                }
                count++;
            } else if (value1.bitArr[i].equals(value1.b0) && value2.bitArr[i].equals(value2.b0)) {
                if (count>0) {
                    count--;
                    value1.bitArr[i] = value1.b1;
                }
            } else if (value1.bitArr[i].equals(value1.b1) && value2.bitArr[i].equals(value2.b0)) {
                if (count>0) {
                    count++;
                    value1.bitArr[i] = value1.b0;
                }
            }
        }
        return count==0;
    }

    public static void main(String[] args) {
        ByteRegister b1 = new ByteRegister((byte)6);
        ByteRegister b2 = new ByteRegister((byte)7);
        Summator.add(b1,b2);
        System.out.println(b1.toDecString());

    }
}
