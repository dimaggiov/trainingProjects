package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.implementations.buggy.*;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterDaoTest {

    MonsterDao testDao = new BadMonsterDaoF();

    @Test
    void testAddGoodMonster() {
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);
        Monster monsterFromAdd = testDao.addMonster(1, testMonster);

        assertNull(monsterFromAdd, "monster added is good so should return null");

        Monster retrievedMonster = testDao.getMonster(1);
        assertEquals(testMonster, retrievedMonster, "retrieved should be the same as the one added");
    }

    @Test
    void testAddDuplicateIDMonster() {
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);

        String secondName = "testName2";
        MonsterType secondType = MonsterType.SWAMPTHING;
        int secondPeopleEaten = 6;
        String secondFavoriteFood = "cats";
        Monster secondTestMonster = new Monster(secondName,secondType,secondPeopleEaten,secondFavoriteFood);

        testDao.addMonster(1, testMonster);
        Monster monsterFrom2ndAdd = testDao.addMonster(1, secondTestMonster);

        assertNotEquals(secondTestMonster,monsterFrom2ndAdd, "second monster was added despite duplicate id");
        assertEquals(monsterFrom2ndAdd, testMonster, "monster returned should be the same as the first added");
    }

    @Test
    void testGetGoodMonster(){
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);
        testDao.addMonster(1, testMonster);


        Monster retrievedMonster = testDao.getMonster(1);

        assertEquals(testMonster, retrievedMonster, "retrieved is not the same as added");
    }

    @Test
    void testGetNonexistentMonster(){
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);
        testDao.addMonster(1, testMonster);


        Monster retrievedMonster = testDao.getMonster(2);

        assertNull(retrievedMonster, "retrieved should be null");
    }

    @Test
    void testGetAllMonster(){
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);

        String secondName = "testName2";
        MonsterType secondType = MonsterType.SWAMPTHING;
        int secondPeopleEaten = 6;
        String secondFavoriteFood = "cats";
        Monster secondTestMonster = new Monster(secondName,secondType,secondPeopleEaten,secondFavoriteFood);

        testDao.addMonster(1, testMonster);
        testDao.addMonster(2, secondTestMonster);

        List<Monster> monsterList = testDao.getAllMonsters();

        assertNotNull(monsterList, "list should not be null");
        assertEquals(2, monsterList.size(), "size should be 2");

        assertTrue(monsterList.contains(testMonster), "list should contain first test monster");
        assertTrue(monsterList.contains(secondTestMonster), "list should contain second test monster");

    }

    @Test
    void testRemoveMonster() {
        String name = "testName1";
        MonsterType type = MonsterType.YETI;
        int peopleEaten = 2;
        String favoriteFood = "people";
        Monster testMonster = new Monster(name,type,peopleEaten,favoriteFood);

        String secondName = "testName2";
        MonsterType secondType = MonsterType.SWAMPTHING;
        int secondPeopleEaten = 6;
        String secondFavoriteFood = "cats";
        Monster secondTestMonster = new Monster(secondName,secondType,secondPeopleEaten,secondFavoriteFood);

        testDao.addMonster(1, testMonster);
        testDao.addMonster(2,secondTestMonster);

        Monster removedMonster = testDao.removeMonster(1);

        assertEquals(testMonster, removedMonster, "test monster 1 should be removed");

        List<Monster> monsterList = testDao.getAllMonsters();

        //check list to see if it was really removed
        assertNotNull(monsterList, "list should not be null");
        assertEquals(1, monsterList.size(), "size should be 1");

        assertFalse(monsterList.contains(testMonster), "list should not contain first test monster");
        assertTrue(monsterList.contains(secondTestMonster), "list should contain second test monster");


        removedMonster = testDao.removeMonster(2);

        assertEquals(secondTestMonster, removedMonster, "test monster 2 should be removed");

        monsterList = testDao.getAllMonsters();

        //check list to see if it was really removed
        assertNotNull(monsterList, "list should not be null");
        assertEquals(0, monsterList.size(), "size should be 0");

        assertFalse(monsterList.contains(testMonster), "list should not contain first test monster");
        assertFalse(monsterList.contains(secondTestMonster), "list should not contain second test monster");

        //make sure you cannot retrieve the monster and that it is null

        assertNull(testDao.getMonster(1), "first monster should be null when retrieved");
        assertNull(testDao.getMonster(2), "second monster should be null when retrieved");

    }





}
