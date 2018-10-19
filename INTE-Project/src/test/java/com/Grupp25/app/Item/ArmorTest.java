package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmorTest {

    Armor armor;

    @Before
    public void setUP() {
        armor = new Armor(10);
    }

    @Test
    public void getProtectionTest() {
        assertEquals(10, armor.getProtection());
    }
}