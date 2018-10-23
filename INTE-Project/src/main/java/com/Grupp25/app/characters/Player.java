package com.Grupp25.app.characters;

import javax.swing.JLabel;


import com.Grupp25.app.gameengine.GameEngine;

public class Player extends Character {
    public static final int INITIAL_HP = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;
    public static final int INITIAL_MinRange = 1;
    public static final int INITIAL_MaxRange = 1;
    

    public Player() {
        super(INITIAL_HP, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy, INITIAL_LEVEL, INITIAL_MinRange, INITIAL_MaxRange);
        this.setGraphics(new PlayerGraphics());
        
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


}