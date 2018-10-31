package com.Grupp25.app.board;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.Grupp25.app.characters.Enemy;

public class BoardTest {

    Board board;
    Enemy enemy;

    @Before
    public void setUP(){
        board = new Board(10, 10);
        enemy = new Enemy();
    }


    @Test
    public void getPositionsSizeTest() {
        assertEquals(100, board.getPositionsSize());
    }

    @Test
    public void getPositionOutOfBoundsTest(){
        assertEquals(null, board.getPosition(10, 10));
    }

    @Test
    public void getPositionTest(){
        Position pos = new Position(5, 5);
        board.setPosition(pos);
        assertEquals(pos, board.getPosition(5, 5));
    }

    @Test
    public void negativePositionTest(){
        assertNull(board.getPosition(-1, -1));
    }

    @Test
    public void outOfBoundsPositionTest(){
        assertNull(board.getPosition(10, 10));
    }

    @Test
    public void getItemAtOutOfBoundsTest(){
        board.addItem(10, 10, enemy);
        assertNull(board.getItemAt(10, 10));
    }

    @Test
    public void getItemAtTest(){
        board.addItem(5, 5, enemy);
        assertEquals(enemy, board.getItemAt(5, 5));
    }

    @Test
    public void removeItemTest(){
        board.addItem(5, 5, enemy);
        board.removeItem(enemy);
        assertNull(board.getItemAt(5, 5));
    }

    @Test
    public void getBoardWidthTest(){
        assertEquals(10, board.getBoardWidth());
    }

    @Test
    public void getBoardHeightTest(){
        assertEquals(10, board.getBoardHeight());
    }
}