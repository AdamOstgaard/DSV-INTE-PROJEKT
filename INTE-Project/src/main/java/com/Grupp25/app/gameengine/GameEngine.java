package com.Grupp25.app.gameengine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Enemy;
import com.Grupp25.app.characters.Player;

public class GameEngine {
    private Board board;
    private BoardItemManager boardItemManager;
    private Player player;
    private Timer timer;

    public GameEngine(Board board) {
        this.boardItemManager = new BoardItemManager(board);
        this.board = board;
        addPlayer();
        addEnemy();
        board.initialize(this);
        startGame();
    }

    public void tick() {
        boardItemManager.doTick(this);
    }

    public void addBoardItem(int x, int y, BoardItem item) {

    }

    public Board getBoard() {
        return board;
    }

    public void startGame() {
        timer = new Timer(750, (ActionEvent e) -> {
            tick();
            timer.restart();
        });
        timer.start();
    }

    private void addPlayer() {
        player = new Player();
        this.boardItemManager.addItem(5, 5, player);
    }

    private void addEnemy() {
        this.boardItemManager.addItem(10, 10, new Enemy());
    }

    public void keyInput(Character input) {
        switch (input.charValue()) {
        case 'a':
            board.moveItem(player, Direction.west);
            break;
        case 'w':
            board.moveItem(player, Direction.north);
            break;
        case 's':
            board.moveItem(player, Direction.south);
            break;
        case 'd':
            board.moveItem(player, Direction.east);
            break;
        }
    }
}