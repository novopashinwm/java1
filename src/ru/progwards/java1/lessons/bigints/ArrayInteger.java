package ru.progwards.java1.lessons.bigints;

import javafx.scene.chart.BubbleChart;

import java.math.BigInteger;

public class ArrayInteger {
    byte[] digits;

    public ArrayInteger(int n) {
        digits = new byte[n];
    }


    public void fromInt(BigInteger value) {
        String str = value.toString();
        digits = new byte[str.length()];
        for (int i = 0; i < digits.length ; i++) {
            digits[digits.length-i-1] = (byte) (str.charAt(i) - '0');
        }
    }

    public BigInteger toInt() {
        String str = "";
        for (int i = digits.length - 1; i >=0 ; i--) {
            str += digits[i];
        }
        return new BigInteger(str);
    }

    boolean add(ArrayInteger num ) {
        if (num.digits.length > this.digits.length) {
            return false;
        }
        int min = Math.min(num.digits.length, this.digits.length);
        byte a, b ,s = 0 , z = 0;
        for (int i = 0; i < min; i++) {
            a = this.digits[i];
            b = num.digits[i];
            s = (byte) (a + b);
            if (z !=0 ) {
                s += z;
                z = 0;
            }
            if (s >=10) {
                z = (byte) (s / 10);
            }
            this.digits[i] = (byte) (s % 10);
        }
        if (z > 0 || s >= 10) {
            for (int i = 0; i < this.digits.length; i++) {
                this.digits[i] = 0;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayInteger ai = new ArrayInteger(2);
        ai.fromInt(new BigInteger("99"));
        System.out.println(ai.toInt());
        ArrayInteger ai1 = new ArrayInteger(1);
        ai1.fromInt(new BigInteger("1"));
        System.out.println(ai.add(ai1));
    }
}
