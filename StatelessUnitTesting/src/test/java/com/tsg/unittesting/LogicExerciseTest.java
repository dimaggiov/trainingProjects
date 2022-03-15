package com.tsg.unittesting;

import com.tsg.unittesting.logic.LogicExerciseA;
import com.tsg.unittesting.logic.LogicExerciseB;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicExerciseTest {

    public LogicExerciseTest(){

    }

    //A TESTS
    @Test
    public void LogicExerciseATestStranger(){
        String name = "name";
        boolean isFriend = false;
        String expected = "hi";
        assertEquals(LogicExerciseA.friendlyGreeting(name,isFriend), expected);
    }

    @Test
    public void LogicExerciseATestFriend(){
        String name = "name";
        boolean isFriend = true;
        String expected = "Hello, name";
        assertEquals(LogicExerciseA.friendlyGreeting(name,isFriend), expected);
    }

    @Test
    public void LogicExerciseATestNoName(){
        String name = null;
        boolean isFriend = false;
        String expected = "...";
        assertEquals(LogicExerciseA.friendlyGreeting(name,isFriend), expected);
    }

    //B TESTS

    @Test
    public void LogicExerciseBTestFirst(){
        int place = 1;
        String expected =  "1st";
        assertEquals(LogicExerciseB.placeOf(place), expected);
    }
    @Test
    public void LogicExerciseBTestSecond(){
        int place = 2;
        String expected =  "2nd";
        assertEquals(LogicExerciseB.placeOf(place), expected);
    }
    @Test
    public void LogicExerciseBTestThird(){
        int place = 3;
        String expected =  "3rd";
        assertEquals(LogicExerciseB.placeOf(place), expected);
    }
    @Test
    public void LogicExerciseBTestFiftySixth(){
        int place = 56;
        String expected =  "56th";
        assertEquals(LogicExerciseB.placeOf(place), expected);
    }


}
