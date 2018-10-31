package com.Grupp25.app;

import static org.junit.Assert.*;

import com.Grupp25.app.characters.GameCharacter;
import com.Grupp25.app.characters.Player;

import org.junit.Before;
import org.junit.Test;

public class GameCharacterTest {

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
    public void getXpTest(){
        assertEquals(0, aCharacter.getXp());
    }

    @Test
    public void getXpForNextLevelTest(){
        assertEquals(100, aCharacter.getXpForNextLevel());
    }

    @Test
    public void determineXpForNextLevelTest(){
        aCharacter.setLevel(4);
        assertEquals(520, aCharacter.determineXpForNextLevel());
    }

    @Test
    public void gainXpTest(){
        aCharacter.gainXp(20);
        assertEquals(20, aCharacter.getXp());
    }

    @Test(expected = IllegalArgumentException.class)
    public void levelUpIllegalArgumentTest() {
        aCharacter.gainXp(-1);
    }

    
    @Test
    public void levelUpTest1(){
        aCharacter.gainXp(0);
        assertEquals(1, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest2() {
        aCharacter.gainXp(99);
        assertEquals(1, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest3(){
        aCharacter.gainXp(100);
        assertEquals(2, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest4(){
        aCharacter.gainXp(99);
        aCharacter.gainXp(120);
        assertEquals(2, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest5(){
        aCharacter.gainXp(100);
        aCharacter.gainXp(120);
        assertEquals(3, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest6(){
        aCharacter.gainXp(359);
        assertEquals(3, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest7(){
        aCharacter.gainXp(360);
        assertEquals(4, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest8(){
        aCharacter.gainXp(519);
        assertEquals(4, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest9(){
        aCharacter.gainXp(520);
        assertEquals(5, aCharacter.getLevel());
    }

    @Test
    public void levelUpTest10(){
        aCharacter.gainXp(699);
        assertEquals(5, aCharacter.getLevel());
    }

    @Test
    public void getMaxHpTest() {
        assertEquals(100, aCharacter.getMaxHp());
    }



    @Test
    public void getDirectionTest() {
        aCharacter.setDirection(Direction.east);
        assertEquals(Direction.east, aCharacter.getDirection());
    }

    @Test
    public void getMinRangeTest(){
        assertEquals(1, aCharacter.getMinAttackRange());
    }

    @Test
    public void getMaxRangeTest(){
        assertEquals(1, aCharacter.getMaxAttackRange());
    }
}