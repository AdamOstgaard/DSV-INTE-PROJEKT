package com.Grupp25.app.characters;

import javax.swing.JLabel;

import com.Grupp25.app.board.BoardItem;
import com.Grupp25.app.gameengine.GameEngine;

public class Explosion extends BoardItem {
    private int timeCounter;

    public Explosion() {
        this.graphics = new ExplosionGraphics();
    }

    @Override
    public void move(GameEngine engine) {
        if (timeCounter >= 2) {
            engine.getBoardItemManager().removeItem(this);
        }
        timeCounter++;
    }

    @Override
    public void setGraphics(JLabel value) {

    }

    @Override
    public JLabel getGraphics() {
        return graphics;
    }

}