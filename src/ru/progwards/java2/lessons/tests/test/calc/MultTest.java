package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MultTest {

    private int val1;
    private int val2;
    private int expected;

    public MultTest(int val1, int val2, int expected) {
        this.val1 = val1;
        this.val2 = val2;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тест {index}: ({0}) * ({1}) = {2}")
    public static Iterable<Integer[]> dataForTest() {
        return Arrays.asList(new Integer[][] {
                {0,0,0}
                , {5,0,0}
                , {-5,-5, 25}
                , {34, 55, 1870}
                , {-34,-55, 1870}
        });

    }
    @Test
    public void testWithParams() {
        assertEquals(expected, SimpleCalculator.mult(val1, val2));
    }
}