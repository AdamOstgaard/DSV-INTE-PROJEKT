package com.Grupp25.app.item;

public class Weapon extends Item {

    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

}