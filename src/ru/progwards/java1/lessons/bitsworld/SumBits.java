package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        int sum = 0;
        if (value < 0) {
            sum +=1;
            value &= 0x7F;
        }

        while (value > 0) {
            sum += value & 1;
            value >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte)7));
    }
}
