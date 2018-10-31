package com.Grupp25.app.item;

import com.Grupp25.app.board.TileGraphics;

public class Weapon extends Item {

    private int damage;
    private int minWeaponRange;
    private int maxWeaponRange;

    public Weapon(int damage, int minWeaponRange, int maxWeaponRange, TileGraphics icon, String name) {
        super(icon, name, ItemType.WEAPON);
        this.damage = damage;
        this.minWeaponRange = minWeaponRange;
        this.maxWeaponRange = maxWeaponRange;

    }

    public int getDamage() {
        return damage;
    }

    public int getMinWeaponRange() {
        return minWeaponRange;
    }

    public int getMaxWeaponRange() {
        return maxWeaponRange;
    }

    public String getName() {
        return this.name;
    }

}