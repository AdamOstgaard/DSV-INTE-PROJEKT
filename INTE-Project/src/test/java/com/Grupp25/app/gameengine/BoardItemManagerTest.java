package com.Grupp25.app.gameengine;

import static org.junit.Assert.*;

import com.Grupp25.app.gameengine.BoardItemManager;
import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.BoardItem;

import org.junit.Test;
import org.junit.Before;

public class BoardItemManagerTest {
    BoardItemManager boardItemManager;
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        boardItemManager  = new BoardItemManager(board);
    }

    
}