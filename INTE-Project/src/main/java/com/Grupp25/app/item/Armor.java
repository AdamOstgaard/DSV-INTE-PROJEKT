package com.Grupp25.app.item;

import java.awt.Image;

import javax.swing.JLabel;

public class Armor extends Item {

    private int protection;
    private static final ItemType itemType = ItemType.ARMOR;



    public Armor(int protection, Image icon, String name) {
        super(icon, name, itemType);
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

}