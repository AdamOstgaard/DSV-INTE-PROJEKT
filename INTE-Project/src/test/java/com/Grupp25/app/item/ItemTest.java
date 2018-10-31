package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    Item item;

    @Before
    public void SetUp() {
        item = new Weapon(5, 1, 1, null, "bow");
    }

    @Test
    public void getItemTypeTest() {
        assertEquals(ItemType.WEAPON, item.getItemType());

    }

}