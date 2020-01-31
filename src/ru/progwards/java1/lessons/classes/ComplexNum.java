package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    private int a, b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNum add(ComplexNum num) {
        return new ComplexNum(this.a +num.a, this.b + num.b);
    }

    public ComplexNum sub(ComplexNum num) {
        return new ComplexNum(this.a - num.a, this.b - num.b);
    }

    public ComplexNum mul(ComplexNum num) {
        return new ComplexNum(this.a * num.a -this.b * num.b, this.b * num.a + this.a * num.b);
    }

    public ComplexNum div(ComplexNum num) {
        //(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
        return new ComplexNum((this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b)
                , (this.b * num.a - this.a * num.b)/ (num.a * num.a + num.b * num.b));
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }
}
