package com.Grupp25.app.characters;

import com.Grupp25.app.board.*;
import com.Grupp25.app.Direction;
import java.lang.Math;

public abstract class GameCharacter extends BoardItem {

    private int hp, maxHp, strength, defense, speed, accuracy, level, minRange, maxRange, xp, nextLevel;
    private Direction direction;

    public GameCharacter(int hp, int maxHp, int strength, int defense, int speed, int accuracy, int level, int minRange,
            int maxRange, int xp) {

        this.hp = hp;
        this.maxHp = maxHp;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.level = level;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.nextLevel = findNextLevel();
        direction = Direction.west;
    }

    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int max){
        this.maxHp = max;
    }

    public int getMaxHp() {
        return this.maxHp;
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

    public int getMinRange() {
        return this.minRange;
    }

    public int getMaxRange() {
        return this.maxRange;
    }

    public int getXp(){
        return this.xp;
    }

    public void gainXp(int i){
        this.xp = this.xp + i;
        while (this.xp >= this.nextLevel) {
            levelUp();
            this.nextLevel = findNextLevel();
        }
    }

    public abstract void levelUp();

    public int findNextLevel(){
        int initial = 100;
        int increase = 20;
        int multiplier = 0;
        int multiplierIncrease = 1;
        for (int i = 1; i < this.getLevel(); i++){
            multiplier = multiplier + multiplierIncrease;
            initial = initial + 100;
            multiplierIncrease ++;
        }
        return initial + (increase * multiplier);
    }

    


    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(Board board, Direction direction) {

    }
}