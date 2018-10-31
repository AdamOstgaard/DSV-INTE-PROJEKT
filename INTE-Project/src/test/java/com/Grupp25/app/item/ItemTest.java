package com.Grupp25.app.item;

import static org.junit.Assert.*;

import java.awt.Color;

import com.Grupp25.app.board.TileGraphics;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    Item item;
    TileGraphics graphics;

    @Before
    public void SetUp() {

        graphics = new TileGraphics(Color.BLACK, null);
        item = new Weapon(5, 1, 1, graphics, "bow");

    }

    @Test
    public void getItemTypeTest() {
        assertEquals(ItemType.WEAPON, item.getItemType());

    }

    @Test
    public void setGraphicsTest() {
        item.setGraphics(graphics);
        assertEquals(item.getGraphics(), graphics);
    }

    @Test
    public void getGraphicsTest() {
        assertEquals(graphics, (TileGraphics) item.getGraphics());
    }

}