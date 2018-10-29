package com.Grupp25.app.item;

import javax.swing.JLabel;
import com.Grupp25.app.characters.Character;

public class Consumable extends Item {

    private int healingPower, amount;
    private static final ItemType itemType = ItemType.CONSUMABLE;


    public Consumable (int healingPower, int amount, JLabel icon, String name){
        super(icon, name, itemType);
        this.healingPower = healingPower;
        this.amount = amount;
    }


    public int getHealingPower() {
        return healingPower;
    }


    public void consume(Character character){
        if (amount > 0){
            amount --;
            character.setHp(character.getHp() + healingPower);
        }
    }

}