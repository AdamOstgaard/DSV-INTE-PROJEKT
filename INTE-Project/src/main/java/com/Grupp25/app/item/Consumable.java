package com.Grupp25.app.item;

public class Consumable extends Item {

    private int healingPower;

    public Consumable(int healingPower) {
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

}