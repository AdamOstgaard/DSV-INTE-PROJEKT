package com.Grupp25.app.board;

public enum Tile {
    grass(1.0, false);
    private final double speedMultiplier;
    private final boolean blocking;

    Tile(double speedMultiplier, boolean blocking) {
        this.speedMultiplier = speedMultiplier;
        this.blocking = blocking;
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
}