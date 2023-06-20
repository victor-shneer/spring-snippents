package com.carmel.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays is a "bridge" between Arrays and Collections
 */
public class ArraysTest {

    @Test
    void arrays(){
        String[] fruits = new String[] {"apple", "pear", "peach"};
        List<String> fruitsList = Arrays.asList(fruits);

        int[] anArray = {2,4,5};
        String str = Arrays.toString(anArray);

        String[] copyTo = Arrays.copyOfRange(fruits, 0,2);
        String[] copyOf = Arrays.copyOf(fruits, 1);

        int[] ints = new int[3];
        Arrays.fill(ints, 6);
    }
}
