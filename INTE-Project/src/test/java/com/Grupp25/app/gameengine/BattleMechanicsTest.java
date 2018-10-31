package com.Grupp25.app.gameengine;

import static org.junit.Assert.*;

import com.Grupp25.app.board.*;
import com.Grupp25.app.characters.*;
import com.Grupp25.app.Direction;
import com.Grupp25.app.gameengine.*;
import com.Grupp25.app.characters.GameCharacter;

import org.junit.Before;
import org.junit.Test;

public class BattleMechanicsTest {

    Board board;
    GameEngine game;
    BattleMechanics battleMechanics;
    Player player;
    Enemy enemy1;
    Enemy enemy2;

    @Before
    public void setUP(){
        board = new Board();
        game = new GameEngine(board);
        battleMechanics = new BattleMechanics();
        enemy1 = new Enemy();
    }

    @Test
    public void searchTargetTest(){
        game.addEnemy(new Position(4, 5), enemy1);
        assertEquals(enemy1, battleMechanics.searchTarget(game.getPlayer(), board));
    }

    @Test
    public void searchTargetTestMiss(){
        game.addEnemy(new Position(3, 5), enemy1);
        assertEquals(null, battleMechanics.searchTarget(game.getPlayer(), board));
    }
    

    @Test
    public void determineHitTest(){
        assertTrue(battleMechanics.determineHit(game.getPlayer(), enemy1, 3));
    }

    @Test
    public void determineHitTestMiss(){
        assertFalse(battleMechanics.determineHit(game.getPlayer(), enemy1, 2));
    }

    @Test
    public void determineDamageTest(){
        battleMechanics.determineDamage(game.getPlayer(),  enemy1, 1);
        assertEquals(94, enemy1.getHp());
    }
}