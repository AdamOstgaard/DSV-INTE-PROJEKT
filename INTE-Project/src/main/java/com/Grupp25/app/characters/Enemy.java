package com.Grupp25.app.characters;

import java.util.Random;

import javax.swing.JLabel;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.Position;
import com.Grupp25.app.gameengine.BoardItemManager;
import com.Grupp25.app.gameengine.GameEngine;

public class Enemy extends GameCharacter {
    public Random random;

    private int explosionTimer;
    private EnemyState state;
    public static final int INITIAL_HP = 100;
    public static final int INITIAL_MaxHp = 100;
    public static final int INITIAL_STRENGTH = 15;
    public static final int INITIAL_DEFENSE = 10;
    public static final int INITIAL_SPEED = 3;
    public static final int INITIAL_Accuracy = 2;
    public static final int INITIAL_LEVEL = 1;
    public static final int INITIAL_MinRange = 1;
    public static final int INITIAL_MaxRange = 1;
    public static final int INITIAL_XP = 10;

    public Enemy() {
        super(INITIAL_HP, INITIAL_MaxHp, INITIAL_STRENGTH, INITIAL_DEFENSE, INITIAL_SPEED, INITIAL_Accuracy,
                INITIAL_LEVEL, INITIAL_MinRange, INITIAL_MaxRange, INITIAL_XP);
        this.setGraphics(new EnemyGraphics());
        random = new Random();
        state = EnemyState.wandering;
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public void move(GameEngine engine) {
        Board board = engine.getBoard();
        switch (getState(engine)) {
        case wandering:
            randomMove(board);
            break;
        case chasing:
            Position playerPos = board.getItemPosition(engine.getPlayer());
            board.moveItem(this, getClosestDirection(playerPos, board));
            break;
        case exploding:
            explode(engine);
            break;
        }
    }

    private void explode(GameEngine engine) {
        BoardItemManager boardItemManager = engine.getBoardItemManager();
        Position pos = engine.getBoard().getItemPosition(this);
        boardItemManager.removeItem(this);

        boardItemManager.replaceItem(pos.getX(), pos.getY(), new Explosion());
        boardItemManager.replaceItem(pos.getX() - 1, pos.getY(), new Explosion());
        boardItemManager.replaceItem(pos.getX() + 1, pos.getY(), new Explosion());
        boardItemManager.replaceItem(pos.getX(), pos.getY() - 1, new Explosion());
        boardItemManager.replaceItem(pos.getX(), pos.getY() + 1, new Explosion());
    }

    @Override
    public JLabel getGraphics() {
        return this.graphics;
    }

    public EnemyState getState() {
        return state;
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

    public Direction getClosestDirection(Position playerPosition, Board board) {
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

    private EnemyState getState(GameEngine engine) {
        Board board = engine.getBoard();
        Position playerPos = board.getItemPosition(engine.getPlayer());
        if (playerPos == null) {
            return EnemyState.wandering;
        }

        Position pos = board.getItemPosition(this);
        if (pos == null) {
            return EnemyState.wandering;
        }

        float distance = pos.getDistanceTo(playerPos);

        if (distance < 5) {
            if (explosionTimer > 3) {
                return EnemyState.exploding;
            }
            explosionTimer++;
        }
        if (distance < 12) {
            return EnemyState.chasing;
        }
        return EnemyState.wandering;
    }
}