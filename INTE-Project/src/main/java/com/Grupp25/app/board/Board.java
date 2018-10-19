package com.Grupp25.app.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Board extends JFrame {
    private HashMap<Integer, Position> positions;
    private int width;
    private int height;
    private Random random;
    private JLayeredPane layeredPane;
    public static final int DEFAULT_TILE_SIZE = 30;

    public Board() {
        this(25, 25);
    }

    public Board(int width, int height) {
        this.height = height;
        this.width = width;

        positions = new HashMap<Integer, Position>();
        random = new Random();
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        this.setLayout(new GridLayout(1, 1));
        this.setVisible(true);
        this.add(layeredPane);
        this.setMinimumSize(new Dimension(DEFAULT_TILE_SIZE * width, DEFAULT_TILE_SIZE * height));
        this.setPreferredSize(new Dimension(DEFAULT_TILE_SIZE * width, DEFAULT_TILE_SIZE * height));

        generatePositions();
        generateTiles();
    }

    private void generatePositions() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Position pos = new Position(i, j);
                positions.put(pos.hashCode(), pos);
            }
        }
    }

    private void generateTiles() {
        positions.values().forEach(p -> {
            if (random.nextBoolean()) {
                return;
            }

            Tile t = new Tile(1, false, new TileGraphics(new Color(0, 200, 0)));
            p.setTile(t);

            TileGraphics tileGraphics = p.getTile().getGraphics();
            addGraphics(p, tileGraphics, 1);
        });
        repaint();
    }

    public void addItem(int x, int y, BoardItem item) {
        Position pos = getPosition(x, y);
        if (pos.getBoardItem() == null) {
            pos.setBoardItem(item);
            addGraphics(pos, item.getGraphics(), 4);
        }
        repaint();
    }

    private void addGraphics(Position p, JLabel graphics, int zIndex) {
        graphics.setBounds((int) getAbsoluteCoordinates(p).getX(), (int) getAbsoluteCoordinates(p).getY(),
                DEFAULT_TILE_SIZE, DEFAULT_TILE_SIZE);

        layeredPane.add(graphics, zIndex);
        graphics.setToolTipText("test");
        graphics.setVisible(true);
    }

    public int getPositionsSize() {
        return positions.size();
    }

    public Position getPosition(int x, int y) throws IllegalArgumentException {
        if (checkBoundries(x, y)) {
            return positions.get(new Position(x, y).hashCode());
        }

        throw new IllegalArgumentException();
    }

    private boolean checkBoundries(int x, int y) {
        return x < width && y < height && x >= 0 && y >= 0;
    }

    private Point2D getAbsoluteCoordinates(Position p) {
        return new Point(p.getX() * DEFAULT_TILE_SIZE, p.getY() * DEFAULT_TILE_SIZE);
    }
}
