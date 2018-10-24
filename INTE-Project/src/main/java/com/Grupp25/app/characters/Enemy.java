package com.Grupp25.app.characters;

import java.util.Random;

import javax.swing.JLabel;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.Position;
import com.Grupp25.app.gameengine.GameEngine;

public class Enemy extends Character {
    public Random random;

    public static final int INITIAL_HP = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;
    public static final int INITIAL_MinRange = 1;
    public static final int INITIAL_MaxRange = 1;

    public Enemy() {
        super(INITIAL_HP, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy, INITIAL_LEVEL,
                INITIAL_MinRange, INITIAL_MaxRange);
        this.setGraphics(new PlayerGraphics());
        random = new Random();
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    // Måste se till att fiender inte kan gå in i varandra.
    @Override
    public void move(GameEngine engine) {
        Board board = engine.getBoard();
        Position playerPos = board.getItemPosition(engine.getPlayer());
        float distance = board.getItemPosition(this).getDistanceTo(playerPos);

        if (distance < 10) {
            board.moveItem(this, getClosestDirection(playerPos, board));
        } else {
            randomMove(board);
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

    private void randomMove(Board board) {
        int r = random.nextInt(5);

        switch (r) {
        case 1:
            move(board, Direction.west);
            break;
        case 2:
            move(board, Direction.east);
            break;
        case 3:
            move(board, Direction.south);
            break;
        case 4:
            move(board, Direction.east);
            break;
        }
    }

    private Direction getClosestDirection(Position playerPosition, Board board) {
        Position ownPositinon = board.getItemPosition(this);

        if ((ownPositinon.getX() - playerPosition.getX()) > 0) {
            return Direction.west;
        }

        if ((ownPositinon.getX() - playerPosition.getX()) < 0) {
            return Direction.east;
        }

        if ((ownPositinon.getY() - playerPosition.getY()) > 0) {
            return Direction.north;
        }
        return Direction.south;
    }
}