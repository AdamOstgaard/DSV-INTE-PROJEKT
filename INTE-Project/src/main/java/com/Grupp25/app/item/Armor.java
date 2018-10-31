package com.Grupp25.app.item;

import com.Grupp25.app.board.TileGraphics;

public class Armor extends Item {

    private int protection;
    private static final ItemType itemType = ItemType.ARMOR;



    public Armor(int protection, TileGraphics icon, String name) {
        super(icon, name, itemType);
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

}