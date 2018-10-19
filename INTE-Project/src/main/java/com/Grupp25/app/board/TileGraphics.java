package com.Grupp25.app.board;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class TileGraphics extends JLabel {
    public TileGraphics(Color color) {
        this.setBackground(color);
        this.setSize(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE);
        setMinimumSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        setPreferredSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        this.setVisible(true);
    }
}