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
    public void gainXpTest(){
        player.gainXp(20);
        assertEquals(20, player.getXp());
    }
}