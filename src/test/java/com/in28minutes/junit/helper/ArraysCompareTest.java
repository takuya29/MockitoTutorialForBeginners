package com.in28minutes.junit.helper;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {1, 2, 12, 4};
        int[] expected = {1, 2, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100)
    public void testSort_Performance() {
        int[] array = {12, 23, 4};
        for (int i = 0; i < 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
