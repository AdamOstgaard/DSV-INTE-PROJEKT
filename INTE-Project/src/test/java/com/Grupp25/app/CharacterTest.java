package com.Grupp25.app;

import static org.junit.Assert.*;

import com.Grupp25.app.characters.GameCharacter;
import com.Grupp25.app.characters.Player;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {

    GameCharacter aCharacter;

    @Before
    public void setUp() throws Exception {
        aCharacter = new Player();
    }

    @Test
    public void getHpTest() {
        assertEquals(100, aCharacter.getHp());
    }

    @Test
    public void getDefenseTest() {
        assertEquals(10, aCharacter.getDefense());
    }

    @Test
    public void getLevelTest() {
        assertEquals(1, aCharacter.getLevel());
    }

    @Test
    public void getStrengthTest() {
        assertEquals(15, aCharacter.getStrength());
    }

    @Test
    public void getAccuracyTest() {
        assertEquals(2, aCharacter.getAccuracy());
    }

    @Test
    public void getSpeedTest() {
        assertEquals(3, aCharacter.getSpeed());
    }

    @Test
    public void getDirectionTest() {
        aCharacter.setDirection(Direction.east);
        assertEquals(Direction.east, aCharacter.getDirection());
    }

    @Test
    public void getMinRangeTest(){
        assertEquals(1, aCharacter.getMinRange());
    }

    @Test
    public void getMaxRangeTest(){
        assertEquals(1, aCharacter.getMaxRange());
    }
}