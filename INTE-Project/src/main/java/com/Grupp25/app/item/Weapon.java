package com.Grupp25.app.item;

import javax.swing.JLabel;

public class Weapon extends Item {

    private int damage;
    private int minWeaponRange;
    private int maxWeaponRange;
    private static final ItemType itemType = ItemType.WEAPON;


    public Weapon(int damage, int minWeaponRange, int maxWeaponRange, JLabel icon, String name) {
       super(icon, name, itemType);
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


    //oklart om vi kommer använda dessa set-metoder
    public void setDamage(int damage) {
        this.damage = damage;

    }

    public void setMinWeaponRange(int minWeaponRange) {
        this.minWeaponRange = minWeaponRange;
    }

    public void setMaxWeaponRange(int maxWeaponRange) {
        this.maxWeaponRange = maxWeaponRange;
    }

}