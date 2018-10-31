package com.Grupp25.app.characters;

import com.Grupp25.app.board.*;
import com.Grupp25.app.Direction;
import java.lang.Math;

public abstract class GameCharacter extends BoardItem {

    private int hp, maxHp, strength, defense, speed, accuracy, level, minAttackRange, maxAttackRange, xp, xpForNextLevel;
    private Direction direction;

    public GameCharacter(int hp, int maxHp, int strength, int defense, int speed, int accuracy, int level, int minAttackRange,
            int maxAttackRange, int xp) {

        this.hp = hp;
        this.maxHp = maxHp;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.level = level;
        this.minAttackRange = minAttackRange;
        this.maxAttackRange = maxAttackRange;
        this.xpForNextLevel = determineXpForNextLevel();
        direction = Direction.west; //The original direction that characters are facing
    }

    public int getHp() {
        return hp;
    }

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

    protected void setStrength(int value) {
        this.strength = value;
    }

    public int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    protected void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getLevel() {
        return level;
    }

    public int getMinAttackRange() {
        return this.minAttackRange;
    }

    public int getMaxAttackRange() {
        return this.maxAttackRange;
    }

    public int getXp(){
        return this.xp;
    }

    public void gainXp(int i){
        this.xp = this.xp + i;
        while (this.xp >= this.xpForNextLevel) {
            levelUp();
            this.xpForNextLevel = determineXpForNextLevel();
        }
    }

    public abstract void levelUp();

    public int determineXpForNextLevel(){
        int xpNextLevel = 100;
        int increase = 120;
        for (int i = 1; i < this.getLevel(); i++){
            xpNextLevel += increase;
            increase += 20;
        }
        this.xpForNextLevel = xpNextLevel;
        return xpNextLevel;
    }

    public int getXpForNextLevel(){
        return this.xpForNextLevel;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(Board board, Direction direction){
        
    }
}