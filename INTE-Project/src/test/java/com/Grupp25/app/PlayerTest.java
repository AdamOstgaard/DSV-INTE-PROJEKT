package com.Grupp25.app;

import static org.junit.Assert.*;

import com.Grupp25.app.characters.Player;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testLevelUp() {
        Player player = new Player();
        player.levelUp();

        assertEquals(2, player.getLevel());
    }
}