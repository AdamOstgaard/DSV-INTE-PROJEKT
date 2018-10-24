package com.Grupp25.app.characters;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;

class ExplosionGraphics extends JLabel {
    public ExplosionGraphics() {
        this.setBackground(new Color(200, 30, 30));
        this.setOpaque(true);
        this.setSize(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3);
        setMinimumSize(new Dimension(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3));
        setPreferredSize(new Dimension(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3));
        this.setVisible(true);
    }
}