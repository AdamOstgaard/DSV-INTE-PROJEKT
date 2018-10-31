package com.Grupp25.app.item;

import com.Grupp25.app.board.TileGraphics;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmorTest {

    Armor armor;
    TileGraphics icon;

    @Before
    public void setUp() {
        armor = new Armor(10, icon, "armor");
    }

    @Test
    public void getProtectionTest() {
        assertEquals(10, armor.getProtection());
    }
}