package com.Grupp25.app.gameengine;

import com.Grupp25.app.board.Board;

public class GameEngine {
    Board board;

    public GameEngine(Board board) {
        this.board = board;
        board.initialize(this);
    }

    public void tick() {

    }

    public void startGame() {
        while (true) {
            tick();
            try {
                Thread.sleep(250);
            } catch (Exception e) {
            }
        }
    }

    public void keyInput(Character input) {

    }
}