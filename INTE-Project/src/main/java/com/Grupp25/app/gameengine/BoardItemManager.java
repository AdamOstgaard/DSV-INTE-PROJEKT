package com.Grupp25.app.gameengine;

import java.util.HashSet;

import com.Grupp25.app.board.BoardItem;

public class BoardItemManager {
    private HashSet<BoardItem> items;

    public BoardItemManager() {
        items = new HashSet<>();
    }

    public void addItem(BoardItem item) {
        this.items.add(item);
    }

    public void removeItem(BoardItem item) {
        this.items.remove(item);
    }

    public void doTick(GameEngine engine) {
        for (BoardItem item : items) {
            item.render(engine);
        }
    }
}