package com.Grupp25.app.item;

import javax.swing.JLabel;
import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Before;
import org.junit.Test;

public class ArmorTest {

    Armor armor;
    Image icon;

    @Before
    public void setUp() {
        armor = new Armor(10, icon, "armor");
    }

    @Test
    public void getProtectionTest() {
        assertEquals(10, armor.getProtection());
    }
}