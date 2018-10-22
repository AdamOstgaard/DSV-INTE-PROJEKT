package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PotionTest {

    Potion potion;

    @Before
    public void setUp() {
        potion = new Potion(50);
    }

    @Test
    public void getHealingPower() {
        assertEquals(50, potion.getHealingPower());
    }
}