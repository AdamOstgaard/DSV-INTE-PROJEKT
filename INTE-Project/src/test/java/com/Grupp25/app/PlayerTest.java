package com.Grupp25.app;

import com.Grupp25.app.characters.Player;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testLevelUp() {
        Player player = new Player();
        player.levelUp();

        assertEquals(2, player.getLevel());
    }
}