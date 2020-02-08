package ru.progwards.java1.lessons.bitsworld;

public class Binary {

    private byte num;

    public Binary(byte num) {
        this.num = num;
    }

    public static void main(String[] args) {
        Binary b = new Binary((byte)-64);
        System.out.println(b);
    }

    @Override
    public String toString() {
        String value = "";
        for (int i=0; i<8; i++) {
            value = (num & 1) +  value;
            num = (byte)(( num & 0xFF) >> 1);
        }
        return value;
    }
}
