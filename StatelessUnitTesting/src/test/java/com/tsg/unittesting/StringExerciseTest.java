package com.tsg.unittesting;

import com.tsg.unittesting.strings.StringsExerciseA;
import com.tsg.unittesting.strings.StringsExerciseE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringExerciseTest {

    public StringExerciseTest() {
    }

    //TEST A
    @Test
    public void StringExerciseATestAllLower(){
        String word = "shhhhhhhhhhhh";
        String expected = "SHHHHHHHHHHHH" ;
        String result = StringsExerciseA.yell(word);
        assertEquals(expected,result);
    }
    @Test
    public void StringExerciseATestMixedCase(){
        String word = "AAaAAAaAAAaaAAHHHH";
        String expected = "AAAAAAAAAAAAAAHHHH" ;
        String result = StringsExerciseA.yell(word);
        assertEquals(expected,result);
    }

    //TEST E

    @Test
    public void StringExerciseETestSameWord(){
        String one = "same";
        String two = "same";

        assertFalse(StringsExerciseE.containsTheOther(one,two));
    }

    @Test
    public void StringExerciseETestFirstInSecond(){
        String one = "one";
        String two = "tone";

        assertTrue(StringsExerciseE.containsTheOther(one,two));
    }

    @Test
    public void StringExerciseETestSecondInFirst(){
        String one = "fancypants";
        String two = "pants";

        assertTrue(StringsExerciseE.containsTheOther(one,two));
    }

    @Test
    public void StringExerciseEDoesNotContain(){
        String one = "llama";
        String two = "duck";

        assertFalse(StringsExerciseE.containsTheOther(one,two));
    }




}


