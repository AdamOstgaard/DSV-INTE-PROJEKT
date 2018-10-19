package com.Grupp25.app.gameengine;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Player;

public class GameEngine {
    Board board;
    BoardItemManager boardItemManager;

    public GameEngine(Board board) {
        this.boardItemManager = new BoardItemManager(board);
        this.board = board;
        addPlayer();
    }

    public void tick() {

    }

    public void addBoardItem(int x, int y, BoardItem item) {

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

    private void addPlayer() {
        this.boardItemManager.addItem(5, 5, new Player());
    }
}