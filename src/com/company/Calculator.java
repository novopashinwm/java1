package com.company;

public class Calculator {
    private int result;

    public Calculator() {
        this.result = 0;
    }

    public void set(int num) {
        this.result = num;
    }

    public void add(int num) {
        this.result += num;
    }

    public void sub(int num) {
        this.result -= num;
    }

    public int getResult() {
        return result;
    }
}
