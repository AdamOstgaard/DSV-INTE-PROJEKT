package com.Grupp25.app.gameengine;

import java.util.HashSet;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.board.Position;

public class BoardItemManager {
    private HashSet<BoardItem> items;
    private HashSet<BoardItem> itemsToBeRemoved;
    private Board board;

    public BoardItemManager(Board board) {
        this.board = board;
        items = new HashSet<>();
        itemsToBeRemoved = new HashSet<>();

    }

    public void addItem(int x, int y, BoardItem item) {
        Position pos = board.getPosition(x, y);
        if (pos != null && pos.getBoardItem() == null) {
            this.items.add(item);
            board.addItem(x, y, item);
        }
    }

    public void replaceItem(int x, int y, BoardItem item) {
        BoardItem prevItem = board.getItemAt(x, y);
        if (prevItem != null) {
            removeItem(prevItem);
        }

        addItem(x, y, item);
    }

    public void removeItem(BoardItem item) {
        this.itemsToBeRemoved.add(item);
        board.removeItem(item);
    }

    public void doTick(GameEngine engine) {
        for (BoardItem item : items) {
            item.move(engine);
        }
        items.removeAll(itemsToBeRemoved);
        itemsToBeRemoved.clear();
    }
}