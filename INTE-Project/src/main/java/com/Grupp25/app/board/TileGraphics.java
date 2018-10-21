package com.Grupp25.app.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class TileGraphics extends JLabel {
    public static final long serialVersionUID = 1L;
    private Image backgroundImage;

    public TileGraphics(Color color) {
        try {
            URL url = getClass().getResource("tile_grass.png");
            File file = new File(url.getPath());
            backgroundImage = ImageIO.read(file);
        } catch (Exception e) {

        }
        this.setBackground(color);
        this.setOpaque(true);
        this.setSize(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE);
        setMinimumSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        setPreferredSize(new Dimension(Board.DEFAULT_TILE_SIZE, Board.DEFAULT_TILE_SIZE));
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}