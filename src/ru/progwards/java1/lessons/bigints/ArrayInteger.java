package ru.progwards.java1.lessons.bigints;

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

        for (int i = 0; i < min; i++) {
           this.digits[i] += num.digits[i];
           if (this.digits[i] > 9) {
               this.digits[i] = (byte) ( this.digits[i] - 10);
               if ((i+1)<= this.digits.length-1) {
                   this.digits[i+1]++;
               }
           }
        }
        if (this.digits[min-1]>9) {
            int i = min-1;
            if (this.digits[i] > 9) {
                this.digits[i] = (byte) (this.digits[i]-10);
                if ((i+1)<= this.digits.length-1) {
                    this.digits[i+1]++;
                }
            }

        }
        if (this.digits[this.digits.length-1]>9) {
            for (int i = 0; i < this.digits.length; i++) {
                this.digits[i] = 0;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(8);
        ai1.fromInt(new BigInteger("10287074"));
        ArrayInteger ai2 = new ArrayInteger(5);
        ai2.fromInt(new BigInteger("87957"));
        ai1.add(ai2);
        System.out.println(ai1.toInt());

    }
}
