package com.Grupp25.app.item;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {

    Weapon weapon;
    JLabel icon;

    @Before
    public void setUp() {
        weapon = new Weapon(50, 1, 5, icon, "Bow");
    }

    @Test
    public void TestgetDamage() {
        assertEquals(50, weapon.getDamage());
    }

    @Test
    public void TestgetMinWeaponRange() {
        assertEquals(1, weapon.getMinWeaponRange());
    }

    @Test
    public void TestgetMaxWeaponRange() {
        assertEquals(5, weapon.getMaxWeaponRange());
    }

}