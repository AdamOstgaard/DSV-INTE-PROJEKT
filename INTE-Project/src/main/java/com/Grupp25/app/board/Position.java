package com.Grupp25.app.board;

public class Position {
    private int x;
    private int y;
    private BoardItem boardItem;
    private Tile tile;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int value) {
        x = value;
    }

    public int getY() {
        return y;
    }

    public void setY(int value) {
        y = value;
    }

    /**
     * @return the boardItem
     */
    public BoardItem getBoardItem() {
        return boardItem;
    }

    /**
     * @param boardItem the boardItem to set
     */
    public void setBoardItem(BoardItem boardItem) {
        this.boardItem = boardItem;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public int hashCode() {
        return x * 7 + y * 13;
    }
}
