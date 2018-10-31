package com.Grupp25.app;

import static org.junit.Assert.assertEquals;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.board.Position;
import com.Grupp25.app.characters.Enemy;
import com.Grupp25.app.characters.Player;
import com.Grupp25.app.gameengine.GameEngine;

import org.junit.Before;
import org.junit.Test;

public class EnemyExplosionTest {
    private Board board;
    private GameEngine engine;
    private Enemy enemy;

    @Before
    public void setUp() {
        board = new Board(10, 10);
        engine = new GameEngine(board);
        engine.getBoardItemManager().addItem(4, 4, new Player());
        engine.getBoardItemManager().addItem(3, 5, new Player());
        engine.getBoardItemManager().addItem(4, 6, new Player());
        enemy = new Enemy();
        engine.getBoardItemManager().addItem(4, 5, enemy);
    }

    @Test
    public void explosionTimerOneTickTest() {
        engine.tick();
        Enemy e = (Enemy) board.getItemAt(4, 5);
        assertEquals(enemy, e);
    }

    @Test
    public void explosionTimerTwoTickTest() {
        engine.tick();
        engine.tick();
        Enemy e = (Enemy) board.getItemAt(4, 5);
        assertEquals(enemy, e);
    }

    @Test
    public void explosionTimerThreeTickTest() {
        engine.tick();
        engine.tick();
        engine.tick();
        Enemy e = (Enemy) board.getItemAt(4, 5);
        assertEquals(enemy, e);
    }

    @Test
    public void explosionTimerFourTickTest() {
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        Enemy e = (Enemy) board.getItemAt(4, 5);
        assertEquals(enemy, e);
    }

    @Test

    public void explosionTimerEnemyDisappearTest() {
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        Enemy e = (Enemy) board.getItemAt(4, 5);
        assertEquals(null, e);
    }

    @Test
    public void explosionTimerEnemyExplodedPositionsEmpty() {
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        BoardItem e = board.getItemAt(3, 5);
        assertEquals(null, e);
    }
}