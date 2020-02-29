package ru.progwards.java1.lessons.queues;

import java.util.Stack;

public class StackCalc {

    Stack<Double> stack = new Stack<>();

    public static Calculate calculate;

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        if (!stack.empty())
            return stack.pop();
        return 0;
    }

    public void add() {
        double a = pop();
        double b = pop();
        push(a+b);
    }

    public void sub() {
        double a = pop();
        double b = pop();
        push( a - b);
    }

    public void mul() {
        double a = pop();
        double b = pop();
        push( a * b);
    }

    public void div() {
        double a = pop();
        double b = pop();
        push( a / b);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int i = stack.peek();
    }

    static class  Calculate {
        public static double calculation1() {
            StackCalc calc = new StackCalc();
            calc.push(12.1);
            calc.push(3.0);
            calc.add();
            calc.push(2.2);
            calc.mul();
            return calc.pop();
        }
        public static double calculation2() {
            return 0.0;
        }

    }
}
