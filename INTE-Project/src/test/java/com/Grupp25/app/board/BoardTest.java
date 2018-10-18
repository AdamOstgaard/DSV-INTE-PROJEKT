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

}