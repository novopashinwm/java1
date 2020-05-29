package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Assert;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

public class DivTestException {

    @Test(expected = ArithmeticException.class)
    public void divDividedZero() {
        Assert.assertEquals(25/0,SimpleCalculator.div(25,0));
    }

}
