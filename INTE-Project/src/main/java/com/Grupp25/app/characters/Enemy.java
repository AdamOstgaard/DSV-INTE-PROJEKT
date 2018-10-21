package com.Grupp25.app.characters;

import java.util.Random;

import javax.swing.JLabel;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.gameengine.GameEngine;

public class Enemy extends Character {
    public Random random;

    public static final int INITIAL_HP = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;

    public Enemy() {
        super(INITIAL_HP, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy, INITIAL_LEVEL);
        this.setGraphics(new PlayerGraphics());
        random = new Random();
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public void move(GameEngine engine) {
        Board board = engine.getBoard();

        int r = random.nextInt(5);

        switch (r) {
        case 1:
            board.moveItem(this, Direction.west);
            break;
        case 2:
            board.moveItem(this, Direction.north);
            break;
        case 3:
            board.moveItem(this, Direction.south);
            break;
        case 4:
            board.moveItem(this, Direction.east);
            break;
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