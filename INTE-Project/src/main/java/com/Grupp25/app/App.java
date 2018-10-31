package com.Grupp25.app;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.gameengine.GameEngine;

/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        GameEngine gameEngine = new GameEngine(board);
        gameEngine.startGame();
    }
}
