package com.Grupp25.app;

public class Character {

    private int hp, strength, defense, speed, accuracy, level;

    public Character(int hp, int strength, int defense, int speed, int accuracy, int level) {

        this.hp=hp;
        this.strength=strength;
        this.defense=defense;
        this.speed=speed;
        this.accuracy=accuracy;
        this.level=level;
    }

    public int getHp(){
        return hp;
    }

    public int getStrength(){
        return strength;
    }
    
    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public int getLevel(){
        return level;
    }
} 