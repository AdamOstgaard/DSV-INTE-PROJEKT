package com.Grupp25.app.item;

import java.awt.Image;

import javax.swing.JLabel;
import com.Grupp25.app.characters.GameCharacter;

public class Consumable extends Item {

    private int healingPower, amount;
    private static final ItemType itemType = ItemType.CONSUMABLE;



    public Consumable (int healingPower, int amount, Image icon, String name){
        super(icon, name);
        this.healingPower = healingPower;
        this.amount = amount;
    }


    public int getHealingPower() {
        return healingPower;
    }


    public void consume(GameCharacter character){
        if (amount > 0){
            amount --;
            character.setHp(character.getHp() + healingPower);
        }
    }

}