package com.Grupp25.app.item;

public class Inventory {

    public Inventory() {
        this.inventory = new Item[INVENTORYSIZE];
    }

    private static final int INVENTORYSIZE = 3;
    /**
     * 0: Weapon 1: Armor 2: Consumable
     */
    public Item[] inventory = new Item[INVENTORYSIZE];

    public Item[] getInventory() {
        return this.inventory;
    }

    public void addItem(Weapon item) {
        this.inventory[0] = item;
    }

    public void addItem(Armor item) {
        this.inventory[1] = item;
    }

    public void addItem(Consumable item) {
        this.inventory[2] = item;
    }

    public void removeItem(ItemType type) {
        switch (type) {
        case ARMOR:
            this.inventory[1] = null;
        case WEAPON:
            this.inventory[0] = null;
        case CONSUMABLE:
            this.inventory[2] = null;
        }
    }

    public Armor getArmor() {
        return (Armor) this.inventory[1];
    }

    public Weapon getWeapon() {
        return (Weapon) this.inventory[0];
    }

    public Consumable getConsumable() {
        return (Consumable) this.inventory[2];
    }

    public int getSize() {
        return this.inventory.length;
    }
}