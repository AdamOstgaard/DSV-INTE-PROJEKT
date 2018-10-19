package com.Grupp25.app.characters;

import com.Grupp25.app.board.*;

public abstract class Character extends BoardItem {

    private int hp, strength, defense, speed, accuracy, level;

    public Character(int hp, int strength, int defense, int speed, int accuracy, int level) {

        this.hp = hp;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    protected void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    protected void setStrenth(int value) {
        this.strength = value;
    }

    public int getDefense() {
        return defense;
    }

    /**
     * @param defense the defense to set
     */
    protected void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    protected void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    protected void setLevel(int level) {
        this.level = level;
    }
}