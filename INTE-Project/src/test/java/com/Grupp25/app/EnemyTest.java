package com.Grupp25.app;

import static org.junit.Assert.assertEquals;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.characters.Enemy;
import com.Grupp25.app.characters.EnemyState;
import com.Grupp25.app.gameengine.GameEngine;

import org.junit.Before;
import org.junit.Test;

public class EnemyTest {
    private Board board;
    private GameEngine engine;
    private Enemy enemy;

    @Before
    public void setUp() {
        board = new Board(10, 10);
        engine = new GameEngine(board);
        enemy = new Enemy();
    }

    @Test
    public void levelUpTest() {
        enemy.levelUp();
        assertEquals(2, enemy.getLevel());
    }

    @Test
    public void getClosestDirectionEast() {
        engine.getBoardItemManager().addItem(4, 5, enemy);
        Direction dir = enemy.getClosestDirection(board.getItemPosition(engine.getPlayer()), board);
        assertEquals(dir, Direction.east);
    }

    @Test
    public void getClosestDirectionWest() {
        engine.getBoardItemManager().addItem(6, 5, enemy);
        Direction dir = enemy.getClosestDirection(board.getItemPosition(engine.getPlayer()), board);
        assertEquals(dir, Direction.west);
    }

    @Test
    public void getClosestDirectionSouth() {
        engine.getBoardItemManager().addItem(5, 4, enemy);
        Direction dir = enemy.getClosestDirection(board.getItemPosition(engine.getPlayer()), board);
        assertEquals(dir, Direction.south);
    }

    @Test
    public void getClosestDirectionNorth() {
        engine.getBoardItemManager().addItem(5, 6, enemy);
        Direction dir = enemy.getClosestDirection(board.getItemPosition(engine.getPlayer()), board);
        assertEquals(dir, Direction.north);
    }

    @Test
    public void testEnemyWhenPlayerDead() {
        engine.getBoardItemManager().removeItem(engine.getPlayer());
        assertEquals(enemy.getState(), EnemyState.wandering);
    }
}