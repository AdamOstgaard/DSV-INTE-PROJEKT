package com.Grupp25.app.characters;

import javax.swing.JLabel;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.gameengine.GameEngine;

public class Player extends GameCharacter {
    public static final int INITIAL_HP = 100;
    public static final int INITIAL_MaxHp = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;
    public static final int INITIAL_MinRange = 1;
    public static final int INITIAL_MaxRange = 1;
    public static final int INITIAL_XP = 0;
    private int xp;

    public Player() {
        super(INITIAL_HP, INITIAL_MaxHp, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy, INITIAL_LEVEL,
                INITIAL_MinRange, INITIAL_MaxRange, INITIAL_XP);
        this.setGraphics(new PlayerGraphics(90));

    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setMaxHp(this.getMaxHp() + 5);
        this.setStrength(this.getStrength() + 2);
        this.setDefense(this.getDefense() + 2);
        this.setSpeed(this.getSpeed() + 1);
        this.setAccuracy(this.getAccuracy() + 1);
    }

    @Override
    public void move(GameEngine engine){
        
    }

    @Override
    public void move(Board board, Direction direction) {
        if (getDirection() != direction) {
            PlayerGraphics graphics = new PlayerGraphics(direction.rotation());
            board.updateGraphics(this, graphics);
            setDirection(direction);
        } else {
            board.moveItem(this, direction);
        }
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