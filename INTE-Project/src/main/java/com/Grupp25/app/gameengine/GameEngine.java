package com.Grupp25.app.gameengine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Enemy;
import com.Grupp25.app.characters.Player;
import com.Grupp25.app.board.Position;

public class GameEngine {
    private Board board;
    private BoardItemManager boardItemManager;
    private Player player;
    private Timer timer;

    public GameEngine(Board board) {
        this.boardItemManager = new BoardItemManager(board);
        this.board = board;
        player = new Player();
        addPlayer(new Position(5, 5), player);
        addEnemy(new Position(1, 5), new Enemy());
        addEnemy(new Position(6, 5), new Enemy());
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

    public void addPlayer(Position pos, Player player) {
        this.boardItemManager.addItem(pos.getX(), pos.getY(), player);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addEnemy(Position pos, Enemy enemy) {
        this.boardItemManager.addItem(pos.getX(), pos.getY(), new Enemy());
    }

    public void keyInput(Character input) {

        switch (input.charValue()) {
        case 'a':
            if (player.getDirection() != Direction.west) {
                player.setDirection(Direction.west);
                return;
            }
            board.moveItem(player, Direction.west);
            break;
        case 'w':
            if (player.getDirection() != Direction.north) {
                player.setDirection(Direction.north);
                return;
            }
            board.moveItem(player, Direction.north);
            break;
        case 's':
            if (player.getDirection() != Direction.south) {
                player.setDirection(Direction.south);
                return;
            }
            board.moveItem(player, Direction.south);
            break;
        case 'd':
            if (player.getDirection() != Direction.east) {
                player.setDirection(Direction.east);
                return;
            }
            board.moveItem(player, Direction.east);
            break;
        case 'k':
            BattleMechanics battle = new BattleMechanics();
            BoardItem target = battle.runBattle(player, board);
            if (target != null)
                boardItemManager.removeItem(target);
            break;
        }
    }
}