package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DivTest {

    private int val1;
    private int val2;
    private int expected;

    public DivTest(int val1, int val2, int expected) {
        this.val1 = val1;
        this.val2 = val2;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тест {index}: ({0}) / ({1}) = {2}")
    public static Iterable<Integer[]> dataForTest() {
        return Arrays.asList(new Integer[][] {
                {0,1,0}
                , {5,1,5}
                , {-5,-5, 1}
                , {42, 6, 7}
                , {250,50, 5}
        });

    }
    @Test
    public void testWithParams() {
        assertEquals(expected, SimpleCalculator.div(val1, val2));
    }

}
