package com.Grupp25.app.gameengine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.characters.Enemy;
import com.Grupp25.app.characters.GameCharacter;
import com.Grupp25.app.characters.Player;
import com.Grupp25.app.board.Position;

public class GameEngine {
    private Board board;
    private BoardItemManager boardItemManager;
    private Player player;
    private Timer timer;
    private int tickCounter;
    private Random random;

    public GameEngine(Board board) {
        this.boardItemManager = new BoardItemManager(board);
        this.board = board;
        player = new Player();
        random = new Random();
        addPlayer(new Position(5, 5), player);
        board.initialize(this);
        startGame();
    }

    public void tick() {
        tickCounter++;
        boardItemManager.doTick(this);
        int nexMonster = tickCounter % 1;
        if (nexMonster == 0) {
            Position pos = new Position(random.nextInt(Board.DEFAULT_TILE_SIZE),
                    random.nextInt(Board.DEFAULT_TILE_SIZE));
            addEnemy(pos, new Enemy());

        }
    }

    public BoardItemManager getBoardItemManager() {
        return boardItemManager;
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
        this.boardItemManager.addItem(pos.getX(), pos.getY(), enemy);
    }

    public void keyInput(Character input) {

        switch (input.charValue()) {
        case 'a':
            player.move(board, Direction.west);
            break;
        case 'w':
            player.move(board, Direction.north);
            break;
        case 's':
            player.move(board, Direction.south);
            break;
        case 'd':
            player.move(board, Direction.east);
            break;
        case 'k':
            BattleMechanics battle = new BattleMechanics();
            GameCharacter target = battle.runBattle(player, board);
            if (target != null && target.getHp() <= 0)
                boardItemManager.removeItem(target);
            break;
        }
    }
}