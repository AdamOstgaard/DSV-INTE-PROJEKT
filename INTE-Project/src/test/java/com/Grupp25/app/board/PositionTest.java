package com.Grupp25.app.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class PositionTest extends TestCase {
    public PositionTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PositionTest.class);
    }

    @org.junit.Test
    public void testGetAndSetX() {
        Position position = new Position(1, 1);
        position.setX(2);
        int x = position.getX();
        assertTrue(x == 2);
    }

    @org.junit.Test
    public void testGetAndSetY() {
        Position position = new Position(1, 1);
        position.setY(2);
        int y = position.getY();
        assertTrue(y == 2);
    }

    @org.junit.Test(expected = Exception.class)
    public void testNegativePositionXValue() {
        new Position(-1, 3);
    }

    @org.junit.Test(expected = Exception.class)
    public void testNegativePositionYValue() {
        new Position(5, -1);
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetNegativeX() {
        Position position = new Position(4, 4);
        position.setX(-2);
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetNegativeY() {
        Position position = new Position(10, 5);
        position.setY(-2);
    }
}