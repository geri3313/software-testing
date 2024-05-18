package org.example;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayExampleTest {

    @Test
    public void testRemoveDuplicates() {

        String[] input = {"Test 1", "Test 2", "Test 3", "Test 1", "Test 2", "Test 4"};
        String[] expectedResult = {"Test 1", "Test 2", "Test 3", "Test 4"};

        String[] result = ArrayExample.removeDuplicates(input);

        Arrays.sort(expectedResult);
        Arrays.sort(result);

        Assertions.assertArrayEquals(expectedResult, result);
    }
}


