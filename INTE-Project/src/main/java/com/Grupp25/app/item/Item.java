package com.Grupp25.app.item;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;

import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.board.TileGraphics;
import com.Grupp25.app.gameengine.GameEngine;

public class Item extends BoardItem {
    String name;
    TileGraphics graphics;


    Item(Image texture, String name) {
        graphics = new TileGraphics(Color.BLACK, texture);
        this.setGraphics(graphics);
        this.name = name;
    }

    @Override
    public void setGraphics(JLabel value) {
		graphics = (TileGraphics) value;
    }

    @Override
    public JLabel getGraphics() {
        return graphics;
    }

    @Override
    public void move(GameEngine engine) {

    }

}