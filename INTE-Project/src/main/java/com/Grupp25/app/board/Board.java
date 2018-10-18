package com.Grupp25.app.board;

import java.util.HashMap;

public class Board {
    private HashMap<Integer, Position> positions = new HashMap<Integer, Position>();
    private int width = 25;
    private int height = 25;

    public Board() {
        generatePositions();
    }

    public Board(int width, int height) {
        this.height = height;
        this.width = width;
        generatePositions();
    }

    private void generatePositions() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Position pos = new Position(i, j);
                positions.put(pos.hashCode(), pos);
            }
        }
    }

    public int getPositionsSize() {
        return positions.size();
    }

    public Position getPosition(int x, int y) {
        if (checkBoundries(x, y)) {
            return positions.get(new Position(x, y).hashCode());
        }

        throw new IllegalArgumentException();
    }

    private boolean checkBoundries(int x, int y) {
        return x < width && y < height && x >= 0 && y >= 0;
    }
}
