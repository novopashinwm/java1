package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Assert;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import static org.junit.Assert.*;

public class DiffException {

    @Test(expected =  ArithmeticException.class)
    public void diffMax() {
        int a = Integer.MAX_VALUE/2 +1;
        int b = Integer.MIN_VALUE/2 -1;
        assertEquals(a-b, SimpleCalculator.diff(a,b));
    }

    @Test(expected =  ArithmeticException.class)
    public void diffMin() {
        int a = Integer.MIN_VALUE/2 -1;
        int b = Integer.MAX_VALUE/2 +1;
        assertEquals(a-b, SimpleCalculator.diff(a,b));
    }

}