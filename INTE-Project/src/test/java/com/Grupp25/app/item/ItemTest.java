package com.Grupp25.app.item;

import static org.junit.Assert.*;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

Item item;

@Before
public void SetUp(){
    item = new Item (new JLabel(), "Axe", ItemType.WEAPON);
}

@Test
public void getItemTypeTest(){
    assertEquals(ItemType.WEAPON, item.getItemType());

}

}