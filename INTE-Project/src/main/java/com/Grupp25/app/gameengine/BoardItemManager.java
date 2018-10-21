package com.Grupp25.app.gameengine;

import java.util.HashSet;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.board.Position;

public class BoardItemManager {
    private HashSet<BoardItem> items;
    private Board board;

    public BoardItemManager(Board board) {
        this.board = board;
        items = new HashSet<>();
    }

    public void addItem(int x, int y, BoardItem item) {
        this.items.add(item);

        Position pos = board.getPosition(x, y);
        if (pos.getBoardItem() == null) {
            board.addItem(x, y, item);
        }
    }

    public void removeItem(BoardItem item) {
        this.items.remove(item);
    }

    public void doTick(GameEngine engine) {
        for (BoardItem item : items) {
            item.move(engine);
        }
    }
}