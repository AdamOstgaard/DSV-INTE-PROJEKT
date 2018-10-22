package com.Grupp25.app.characters;

import javax.swing.JLabel;

import com.Grupp25.app.Direction;
import com.Grupp25.app.gameengine.GameEngine;

public class Player extends Character {
    public static final int INITIAL_HP = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;
    private Direction direction;

    public Player() {
        super(INITIAL_HP, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy, INITIAL_LEVEL);
        this.setGraphics(new PlayerGraphics());
        direction = Direction.west;
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public void move(GameEngine engine) {

    }

    @Override
    public JLabel getGraphics() {
        return this.graphics;
    }

    @Override
    public void setGraphics(JLabel value) {
        this.graphics = value;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}