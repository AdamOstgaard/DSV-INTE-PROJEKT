package com.Grupp25.app.item;

import com.Grupp25.app.characters.*;
import com.Grupp25.app.characters.Character;

public class Potion extends Item implements Consumable {

    private int healingPower, amount;


    public Potion (int healingPower, int amount){
        this.healingPower = healingPower;
        this.amount = amount;
    }


    public int getHealingPower() {
        return healingPower;
    }

    @Override
    public void consume(Character character){
        if (amount > 0){
            amount --;
            character.setHp(character.getHp() + healingPower);
        }
    }

}