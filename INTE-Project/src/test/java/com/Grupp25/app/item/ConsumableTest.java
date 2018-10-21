package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsumableTest {

    Consumable consumable;

    @Before
    public void setUp() {
        consumable = new Consumable(50);
    }

    @Test
    public void getHealingPower() {
        assertEquals(50, consumable.getHealingPower());
    }
}