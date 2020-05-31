package ru.progwards.java2.lessons.tests.test.calc;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses( { DiffException.class, DiffTest.class
        , DivTest.class, DivTestException.class, MultException.class
        , MultTest.class, SumException.class, SumTest.class})
@RunWith(Suite.class)
public class AllTests extends TestSuite {
    public AllTests () {

    }
}
