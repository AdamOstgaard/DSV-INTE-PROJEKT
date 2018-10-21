package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {

    Weapon weapon;

    @Before
    public void setUp() {
        weapon = new Weapon(50);
    }

    @Test
    public void getDamageTest() {
        assertEquals(50, weapon.getDamage());
    }
}