package com.Grupp25.app.item;

import com.Grupp25.app.characters.*;
import com.Grupp25.app.characters.Character;

public class Potion extends Item implements Consumable {

    private int healingPower, amount;
    private Character character;


    public Potion (int healingPower){
        this.healingPower = healingPower;
    }
    public Potion(int healingPower, Character c) {
        this.healingPower = healingPower;
        this.character = c;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void Consume(Character character){
        if (amount > 0)
            character.setHp(character.getHp() + healingPower);
    }

    /*
    consume2 är ett alternativ om logiken för att faktiskt utföra heal inte bör utföras i potionklassen
    public int Consume2() {
        if (amount > 0) {
            amount --;
            return healingPower;
        }
        return 0;
    }
    */
}