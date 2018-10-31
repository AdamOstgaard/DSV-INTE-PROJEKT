package com.Grupp25.app.item;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.JLabel;

import com.Grupp25.app.board.TileGraphics;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {

    Weapon weapon;
    TileGraphics icon;
    

    @Before
    public void setUp() {
        weapon = new Weapon(50, 1, 5, icon, "Bow");
    }

    @Test
    public void getDamageTest() {
        assertEquals(50, weapon.getDamage());
    }

    @Test
    public void getMinWeaponRangeTest() {
        assertEquals(1, weapon.getMinWeaponRange());
    }

    @Test
    public void getMaxWeaponRangeTest() {
        assertEquals(5, weapon.getMaxWeaponRange());
    }

}