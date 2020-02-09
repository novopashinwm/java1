package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    protected Number num;

    public void setNum(Number num) {
        this.num = num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int res =  num1.getNum().intValue() + num2.getNum().intValue();
        if (res >= Byte.MIN_VALUE && res <= Byte.MAX_VALUE)
            return new ByteInteger((byte)res);
        else if (res >= Short.MIN_VALUE && res <= Short.MAX_VALUE)
            return new ShortInteger((short) res);
        else if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE)
            return new IntInteger(res);
        return null;
    }

    public abstract Number getNum();

    public static void main(String[] args) {
        System.out.println(AbsInteger.add(new ByteInteger((byte)120), new ByteInteger((byte)9)));

    }
}
