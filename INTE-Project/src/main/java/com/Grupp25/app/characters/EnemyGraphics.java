package com.Grupp25.app.characters;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;

class EnemyGraphics extends JLabel {
    public EnemyGraphics() {
        this.setBackground(new Color(0, 30, 120));
        this.setOpaque(true);
        this.setSize(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3);
        setMinimumSize(new Dimension(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3));
        setPreferredSize(new Dimension(Board.DEFAULT_TILE_SIZE * 3, Board.DEFAULT_TILE_SIZE * 3));
        this.setVisible(true);
    }
}