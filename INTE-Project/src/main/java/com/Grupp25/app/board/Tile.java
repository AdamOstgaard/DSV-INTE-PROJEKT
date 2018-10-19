package com.Grupp25.app.board;

public class Tile {
    private final double speedMultiplier;
    private final boolean blocking;
    private final TileGraphics graphics;

    Tile(double speedMultiplier, boolean blocking, TileGraphics graphics) {
        this.speedMultiplier = speedMultiplier;
        this.blocking = blocking;
        this.graphics = graphics;
    }

    /**
     * @return the speedMultiplier
     */
    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public boolean getBlocking() {
        return blocking;
    }

    public TileGraphics getGraphics() {
        return this.graphics;
    }

}