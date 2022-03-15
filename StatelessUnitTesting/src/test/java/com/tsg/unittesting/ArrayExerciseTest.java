package com.tsg.unittesting;

import com.tsg.unittesting.arrays.ArrayExerciseA;
import com.tsg.unittesting.arrays.ArrayExerciseB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayExerciseTest {

    /*
     * maxOfArray( {1}  ) ->  1
     * maxOfArray( {3,4,5}  ) ->  5
     * maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
     */
    public ArrayExerciseTest(){
    }
    //EXERCISE A TEST
    @Test
    public void ArrayExerciseATestSize1(){
        int [] test = {1};
        assertEquals(ArrayExerciseA.maxOfArray(test), 1, "{1} should be 1");
    }

    @Test
    public void ArrayExerciseATestAllPositive(){

        int [] test = {3,4,5} ;
        assertEquals(ArrayExerciseA.maxOfArray(test), 5, "{3,4,5} should be 5");
    }

    @Test
    public void ArrayExerciseATestAllNegative(){

        int [] test = {-9000, -700, -50, -3};
        assertEquals(ArrayExerciseA.maxOfArray(test) , -3, "{-9000, -700, -50, -3} should be -3");
    }


    //EXERCISE B TEST

    /*
     * multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
     * multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
     * multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     */

    @Test
    public void ArrayExerciseBTestZeroMultiplier(){
        int multiplier = 0;
        int[] numbers = {1, 1, 1, 1, 1 ,1 ,1 ,1 ,1};
        int[] expected = {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };

        assertArrayEquals(ArrayExerciseB.multiplyAll(multiplier,numbers), expected);
    }

    @Test
    public void ArrayExerciseBTestPositiveMultiplier(){
        int multiplier = 5;
        int[] numbers = {1 , 2 , 3 , 4 , 5 };
        int[] expected = {5 , 10 , 15 , 20 , 25 };

        assertArrayEquals(ArrayExerciseB.multiplyAll(multiplier,numbers), expected);
    }

    @Test
    public void ArrayExerciseBTestNegativeMultiplier(){
        int multiplier = -1;
        int[] numbers = {-2 , 0 , 0 , 1 };
        int[] expected =  {2 , 0 , 0 , -1};

        assertArrayEquals(ArrayExerciseB.multiplyAll(multiplier,numbers), expected);
    }


    //EXERCISE C TEST

    //EXERCISE D TEST

    //EXERCISE E TEST

}
