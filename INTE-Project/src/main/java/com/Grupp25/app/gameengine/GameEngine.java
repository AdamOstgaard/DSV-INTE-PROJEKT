package com.Grupp25.app.gameengine;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Player;

public class GameEngine {
    Board board;
    BoardItemManager boardItemManager;
    Player player;

    public GameEngine(Board board) {
        this.boardItemManager = new BoardItemManager(board);
        this.board = board;
        addPlayer();
        board.initialize(this);
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
        player = new Player();
        this.boardItemManager.addItem(5, 5, player);
    }

    public void keyInput(Character input) {
        switch (input) {
        case 'a':
            board.moveItemWest(player);
        }
    }
}