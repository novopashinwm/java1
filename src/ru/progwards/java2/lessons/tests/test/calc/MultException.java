package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Assert;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

public class MultException {

    @Test(expected =  ArithmeticException.class)
    public void multMax() {
        int value = Integer.MAX_VALUE;
        Assert.assertEquals(value*value, SimpleCalculator.mult(value,value));
    }

    @Test(expected =  ArithmeticException.class)
    public void multMin() {
        int value = Integer.MIN_VALUE;
        Assert.assertEquals(value*value, SimpleCalculator.mult(value,value));
    }
}
