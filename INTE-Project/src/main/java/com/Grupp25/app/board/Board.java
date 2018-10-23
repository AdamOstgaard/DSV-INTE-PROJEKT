package com.Grupp25.app.board;

import com.Grupp25.app.Direction;
import com.Grupp25.app.board.Textures.TextureHandler;
import com.Grupp25.app.gameengine.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class Board extends JFrame implements KeyListener {
    private GameEngine gameEngine;
    private HashMap<Integer, Position> positions;
    private int width;
    private int height;
    private Random random;
    private JLayeredPane layeredPane;
    public static final long serialVersionUID = 1L;
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
        addKeyListener(this);

        generatePositions();
        generateTiles();
    }

    public void initialize(GameEngine g) {
        this.gameEngine = g;
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
        TextureHandler textureHandler = new TextureHandler();
        positions.values().forEach(p -> {
            if (random.nextBoolean()) {
                return;
            }

            Tile t = new Tile(1, false, new TileGraphics(new Color(0, 200, 0), textureHandler.getGrassTexture()));
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

    public void moveItem(BoardItem item, Direction direction) {
        Position p = getItemPosition(item);
        Position nextPosition = getNextPosition(direction, p);            
        if (nextPosition != null && nextPosition.getBoardItem() == null) {
            p.setBoardItem(null);
            nextPosition.setBoardItem(item);
            addGraphics(nextPosition, item.getGraphics(), 4);
            return;
        }
    }

    public Position getItemPosition(BoardItem item) {
        for (Position p : positions.values()) {
            if (p.getBoardItem() != null && p.getBoardItem() == item) {
                return p;
            }
        }
        return null;
    }

    public int getPositionsSize() {
        return positions.size();
    }

    public BoardItem getItemAt(int x, int y){
        BoardItem item;
        item = getPosition(x, y).getBoardItem();
        return item;
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

    // Listeners

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameEngine.keyInput(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public Position getNextPosition(Direction direction, Position p) {
        switch (direction) {
        case east:
            return getPosition(p.getX() + 1, p.getY());
        case west:
            return getPosition(p.getX() - 1, p.getY());
        case north:
            return getPosition(p.getX(), p.getY() - 1);
        case south:
            return getPosition(p.getX(), p.getY() + 1);
        default:
            return null;
        }
    }
}
