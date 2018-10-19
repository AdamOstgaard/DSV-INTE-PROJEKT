package com.Grupp25.app.board;

import org.junit.rules.ExpectedException;

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
        Position pos = new Position(1, 1);
        pos.setX(2);
        int x = pos.getX();
        assertTrue(x == 2);
    }

    @org.junit.Test
    public void testGetAndSetY() {
        Position pos = new Position(1, 1);
        pos.setY(2);
        int y = pos.getY();
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
        Position pos = new Position(4, 4);
        pos.setX(-2);
    }

    @org.junit.Test(expected = Exception.class)
    public void testSetNegativeY() {
        Position pos = new Position(10, 5);
        pos.setY(-2);
    }
}