package com.Grupp25.app.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void SetUp() {
        inventory = new Inventory();
    }

    @Test
    public void addWeaponTest() {
        Weapon weapon = new Weapon(5, 4, 5, null, "bow");
        inventory.addItem(weapon);
        assertEquals(inventory.getInventory()[0], weapon);
    }

    @Test
    public void addArmorTest() {
        Armor armor = new Armor(5, null, "helmet");
        inventory.addItem(armor);
        assertEquals(inventory.getInventory()[1], armor);
    }

    @Test
    public void addConsumableTest() {
        Consumable consumable = new Consumable(5, 5, null, "potion");
        inventory.addItem(consumable);
        assertEquals(inventory.getInventory()[2], consumable);
    }

    @Test
    public void removeArmorTest() {
        inventory.removeItem(ItemType.ARMOR);
        assertEquals(inventory.getInventory()[1], null);
    }

    @Test
    public void removeWeaponTest() {
        inventory.removeItem(ItemType.WEAPON);
        assertEquals(inventory.getInventory()[0], null);
    }

    @Test
    public void removeConsumableTest() {
        inventory.removeItem(ItemType.CONSUMABLE);
        assertEquals(inventory.getInventory()[2], null);
    }

    @Test
    public void inventorySizeTest() {
        int size = inventory.getSize();
        assertEquals(size, 3);
    }

    @Test
    public void getArmorTest() {
        Armor armor = new Armor(0, null, "name");

        this.inventory.addItem(armor);

        Item item = this.inventory.getArmor();

        assertEquals(item, armor);
    }

    @Test
    public void getWeaponTest() {
        Weapon weapon = new Weapon(1, 1, 1, null, "name");

        this.inventory.addItem(weapon);

        Item item = this.inventory.getWeapon();

        assertEquals(item, weapon);
    }

    @Test
    public void getConsumableTest() {
        Consumable consumable = new Consumable(1, 1, null, "name");

        this.inventory.addItem(consumable);

        Item item = this.inventory.getConsumable();

        assertEquals(item, consumable);
    }

    @Test(expected = ClassCastException.class)
    public void getWrongItemTypeTest() {
        // sets weapon on armor array place
        Weapon w = new Weapon(1, 1, 1, null, "name");
        inventory.inventory[1] = w;
        inventory.getArmor();
    }
}