package com.Grupp25.app;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Explosion;
import com.Grupp25.app.gameengine.GameEngine;

import org.junit.Before;
import org.junit.Test;

public class ExplosionTest {
    private GameEngine engine;

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
        engine = new GameEngine(board);
    }

    @Test
    public void explosionTimerOneTickTest() {
        Explosion explosion = new Explosion();
        engine.getBoardItemManager().addItem(1, 1, explosion);

        engine.tick();
        BoardItem item = board.getItemAt(1, 1);
        assertEquals((Explosion) item, explosion);

    }

    @Test
    public void explosionTimerTwoTickTest() {
        Explosion explosion = new Explosion();
        engine.getBoardItemManager().addItem(1, 1, explosion);
        engine.tick();
        engine.tick();
        BoardItem item = board.getItemAt(1, 1);
        assertEquals((Explosion) item, explosion);

    }

    @Test
    public void explosionTimerThreeTickTest() {
        Explosion explosion = new Explosion();
        engine.getBoardItemManager().addItem(1, 1, explosion);
        engine.tick();
        engine.tick();
        engine.tick();
        BoardItem item = board.getItemAt(1, 1);
        assertEquals((Explosion) item, explosion);

    }

    @Test
    public void explosionTimerFourTickTest() {
        Explosion explosion = new Explosion();
        engine.getBoardItemManager().addItem(1, 1, explosion);
        engine.tick();
        engine.tick();
        engine.tick();
        engine.tick();
        BoardItem item = board.getItemAt(1, 1);
        assertEquals(null, item);

    }

    @Test
    public void setGraphicsTest() {
        Explosion explosion = new Explosion();
        JLabel g = explosion.getGraphics();
        // No-op
        explosion.setGraphics(null);
        assertEquals(explosion.getGraphics(), g);
    }
}