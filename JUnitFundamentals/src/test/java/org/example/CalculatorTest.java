package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

 
    @Test
    public void sumTest() {
        Calculator calculator = new Calculator();
        int td1 = 2, td2 = 3;
        int expectedTestResult = 5;
        int actualResult=calculator.sum(td1, td2);

        Assertions.assertEquals(expectedTestResult, actualResult);
    }

    @Test
    public void substractTest() {
        Calculator calculator = new Calculator();
        int tds1 = 10, tds2 = 9;
        int expectedTestResult1 = 1;
        int actualResult1=calculator.substract(tds1, tds2);

        Assertions.assertEquals(expectedTestResult1, actualResult1);
    }

    @Test
    public void multiplicationTest() {
        Calculator calculator = new Calculator();
        int tdm1 = 10, tdm2 = 10;
        int expectedTestResult2 = 100;
        int actualResult2=calculator.multiplication(tdm1, tdm2);

        Assertions.assertEquals(expectedTestResult2, actualResult2);
    }

    @Test
    public void divisionTest() {
        Calculator calculator = new Calculator();
        int tdd1 = 10, tdd2 = 10;
        int expectedTestResult3 = 1;
        int actualResult3=calculator.division(tdd1, tdd2);

        Assertions.assertEquals(expectedTestResult3, actualResult3);
    }
}
