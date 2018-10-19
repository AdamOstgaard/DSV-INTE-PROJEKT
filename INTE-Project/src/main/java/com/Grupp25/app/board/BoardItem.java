package com.Grupp25.app.board;

import javax.swing.JLabel;

import com.Grupp25.app.gameengine.GameEngine;

public abstract class BoardItem {
    public abstract void render(GameEngine engine);

    protected JLabel graphics;

    public abstract void setGraphics(JLabel value);

    public abstract JLabel getGraphics();
}