package com.Grupp25.app.item;

import com.Grupp25.app.board.BoardItem;

public class Armor extends Item {

    private int protection;

    public Armor(int protection) {
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

}