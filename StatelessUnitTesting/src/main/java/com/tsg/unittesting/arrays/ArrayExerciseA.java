/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.arrays;

import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseA {
    
    /**
     * Given an array of ints, find and return the maximum value.
     * 
     * Example Results:
     * maxOfArray( {1}  ) ->  1
     * maxOfArray( {3,4,5}  ) ->  5
     * maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
     * 
     * @param numbers array of integers
     * @return int max
     */
    public static int maxOfArray(int[] numbers){
        int[] sortedCopy = Arrays.copyOf(numbers,numbers.length);
        Arrays.sort(sortedCopy);
        return sortedCopy[numbers.length-1];
    }
    
}