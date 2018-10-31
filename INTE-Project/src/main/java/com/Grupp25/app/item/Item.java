package com.Grupp25.app.item;


import javax.swing.JLabel;

import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.board.TileGraphics;
import com.Grupp25.app.gameengine.GameEngine;

public abstract class Item extends BoardItem {
    String name;
    ItemType itemType;
    TileGraphics graphics;

    Item(TileGraphics texture, String name, ItemType itemType) {
        this.graphics = texture;
        this.setGraphics(graphics);
        this.name = name;
        this.itemType = itemType;
    }

    @Override
    public void setGraphics(JLabel value) {
        this.graphics = (TileGraphics) value;
    }

    @Override
    public JLabel getGraphics() {
        return graphics;
    }

    @Override
    public void move(GameEngine engine) {

    }

    public ItemType getItemType() {
        return itemType;
    }

}