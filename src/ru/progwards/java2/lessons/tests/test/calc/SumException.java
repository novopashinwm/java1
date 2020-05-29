package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Assert;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import static org.junit.Assert.*;

public class SumException {

    @Test (expected = ArithmeticException.class)
    public void sumMax() {
        int value = Integer.MAX_VALUE/2 + 1;
        Assert.assertEquals(value+value, SimpleCalculator.sum(value,value));
    }

    @Test (expected = ArithmeticException.class)
    public void sumMin() {
        int value = Integer.MIN_VALUE/2 - 1;
        Assert.assertEquals(value+value, SimpleCalculator.sum(value,value));
    }

}