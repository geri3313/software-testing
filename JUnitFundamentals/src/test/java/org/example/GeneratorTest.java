package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @Test
    public void testGenerateNumberMethod() {

//        int[] expectedResult = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int actualResult = Generator.generateRandomNumber();

//        boolean flag = false;
//        for (int x : expectedResult) {
//            if (x == actualResult) {
//                flag = true;
//                break;
//            }
//        }
//        Assertions.assertTrue(flag);
//        Assertions.assertTrue(actualResult >=-10 && actualResult<=10);
        
        Assertions.assertTrue(actualResult >= -10 && actualResult <= 10);
    }

}