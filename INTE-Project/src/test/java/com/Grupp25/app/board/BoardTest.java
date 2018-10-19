package com.Grupp25.app.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoardTest extends TestCase {
    public BoardTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PositionTest.class);
    }

    @org.junit.Test
    public void testBoardCreate() {
        Board testBoard = new Board(2, 2);
        assertTrue(testBoard.getPositionsSize() == 4);
    }

    @org.junit.Test
    public void testGetExistingPosition(){
        Board testBoard = new Board(20, 25);
        assertTrue(testBoard.getPosition(10, 10) != null);
    }

    @org.junit.Test
    public void testNegativePosition(){
        Board testBoard = new Board(15, 10);
        assertNull(testBoard.getPosition(-1, -1));
    }

    @org.junit.Test
    public void testOutOfBoundsPosition(){
        Board testBoard = new Board(30, 30);
        assertNull(testBoard.getPosition(31, 30));
    }

}