package com.Grupp25.app.item;

import javax.swing.JLabel;

import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.gameengine.GameEngine;

public class Item extends BoardItem {
    JLabel graphics;
    String name;
    ItemType itemType;


    Item(JLabel icon, String name, ItemType itemType) {
        this.setGraphics(icon);
        this.name = name;
        this.itemType = itemType;
    }

    @Override
    public void setGraphics(JLabel value) {
        graphics = value;
    }

    @Override
    public JLabel getGraphics() {
        return graphics;
    }

    @Override
    public void move(GameEngine engine) {

    }

    public ItemType getItemType(){
        return itemType;
    }

}