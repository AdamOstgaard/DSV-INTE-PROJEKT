package com.Grupp25.app;

import static org.junit.Assert.*;

import org.junit.Test;

class PlayerTest {
    @Test
    public void testLevelUp() {
        Player player = new Player();
        player.levelUp();

        assertEquals(2, player.getLevel());
    }
}