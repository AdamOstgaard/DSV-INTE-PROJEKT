package com.Grupp25.app.gameengine;

import static org.junit.Assert.*;

import com.Grupp25.app.board.*;
import com.Grupp25.app.characters.*;
import com.Grupp25.app.Direction;
import com.Grupp25.app.gameengine.*;

import org.junit.Before;
import org.junit.Test;

public class BattleMechanicsTest {

    Board board;
    GameEngine game;
    BattleMechanics battleMechanics;
    Enemy enemy;

    @Before
    public void setUP(){
        board = new Board();
        game = new GameEngine(board);
        battleMechanics = new BattleMechanics();
    }

    @Test
    public void fireTest(){
        assertEquals(board.getItemAt(1, 5), battleMechanics.fire(game.getPlayer(), board));
    }



}