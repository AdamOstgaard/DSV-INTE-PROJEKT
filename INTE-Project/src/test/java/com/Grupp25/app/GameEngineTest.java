package com.Grupp25.app;

import static org.junit.Assert.assertTrue;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.gameengine.GameEngine;

import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {
    GameEngine engine;
    Board board;

    @Before
    public void setUp() {
        board = new Board(6, 6);
        this.engine = new GameEngine(board);
    }

    @Test
    public void startGameTest() {
        engine.startGame();
        assertTrue(engine.isRunning());
    }
}