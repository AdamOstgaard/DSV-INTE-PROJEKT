package com.Grupp25.app;

import com.Grupp25.app.characters.Player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Player player;

    @Before
    public void setUP(){
    player = new Player();
    }

    @Test
    public void testLevelUp() {
        player.levelUp();
        assertEquals(2, player.getLevel());
    }
    
    @Test
    public void LevelUpMaxHpTest() {
        player.levelUp();
        assertEquals(105, player.getMaxHp());
    }

    @Test
    public void LevelUpStrengthTest() {
        player.levelUp();
        assertEquals(17, player.getStrength());
    }

    @Test
    public void LevelUpDefenseTest() {
        player.levelUp();
        assertEquals(12, player.getDefense());
    }

    @Test
    public void LevelUpSpeedTest() {
        player.levelUp();
        assertEquals(4, player.getSpeed());
    }

    @Test
    public void LevelUpAccuracyTest() {
        player.levelUp();
        assertEquals(3, player.getAccuracy());
    }

    @Test
    public void gainXpTest(){
        player.gainXp(20);
        assertEquals(20, player.getXp());
    }
}