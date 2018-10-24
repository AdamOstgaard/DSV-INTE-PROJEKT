package com.Grupp25.app;

public enum Direction {

    west(90), south(0), north(180), east(270);

    private int rotation;

    Direction(int rotation) {
        this.rotation = rotation;
    }

    public int rotation() {
        return rotation;
    }
}