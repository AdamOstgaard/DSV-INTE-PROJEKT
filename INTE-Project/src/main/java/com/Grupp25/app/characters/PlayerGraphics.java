package com.Grupp25.app.characters;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;

public class PlayerGraphics extends JLabel {
    public PlayerGraphics() {
        this.setBackground(new Color(30, 30, 30));
        this.setOpaque(true);
        this.setSize(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE);
        setMinimumSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        setPreferredSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        this.setVisible(true);
    }
}