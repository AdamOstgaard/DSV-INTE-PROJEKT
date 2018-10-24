package com.Grupp25.app.characters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.JLabel;

import com.Grupp25.app.board.Board;

public class PlayerGraphics extends JLabel {
    private int side;
    private final Path2D path2D;
    private int rotation;

    public PlayerGraphics(int rotation) {
        this.rotation = rotation;
        side = Board.DEFAULT_TILE_SIZE;
        path2D = new Path2D.Double();
        this.setBackground(new Color(30, 30, 30));
        this.setOpaque(true);
        this.setSize(side, side);
        setMinimumSize(new Dimension(side, side));
        setPreferredSize(new Dimension(side, side));
        this.setVisible(true);
        drawPath();
    }

    private void drawPath() {
        double yOffset = (side * 0.5);
        double startX = (side / 2.0) * (1 - 1 / Math.sqrt(3));
        double startY = (3.0 * side / 4.0);

        path2D.moveTo(startX, startY - yOffset);
        path2D.lineTo((side - startX), startY - yOffset);
        path2D.lineTo((side / 2.0), (side * 1.25) - yOffset);
        path2D.closePath();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setPaint(Color.RED);

        g2.rotate(Math.toRadians(rotation), side / 2f, side / 2f);
        g2.fill(path2D);
    }
}