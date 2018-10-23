package com.Grupp25.app.item;

import javax.swing.JLabel;

public class Armor extends Item {

    private int protection;

    public Armor(int protection, JLabel icon, String name) {
        super(icon, name);
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

}