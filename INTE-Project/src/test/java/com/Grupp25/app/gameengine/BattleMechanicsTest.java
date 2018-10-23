package com.Grupp25.app.gameengine;

import static org.junit.Assert.*;

import com.Grupp25.app.board.*;
import com.Grupp25.app.characters.*;
import com.Grupp25.app.Direction;
import com.Grupp25.app.gameengine.*;
import com.Grupp25.app.characters.Character;

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
        // player = new Player();
        // enemy1 = new Enemy();
        // enemy2 = new Enemy();
        // game.addPlayer(new Position(5, 5), player);
        // game.addEnemy(new Position(2, 5), enemy1);
        // game.addEnemy(new Position(6, 5), enemy2);
    }

    //Är just nu beroende av vart spelaren och fienden spawnar.
    @Test
    public void searchTargetTest(){
        assertEquals(board.getItemAt(1, 5), battleMechanics.searchTarget(game.getPlayer(), board));
    }

    @Test
    public void determineHitTest(){
        assertTrue(battleMechanics.determineHit(game.getPlayer(), enemy1, 3));
    }

    @Test
    public void determineDamageTest(){
        Character fiende = (Character) board.getItemAt(1, 5);
        battleMechanics.determineDamage(game.getPlayer(),  fiende, 1);
        assertEquals(94, fiende.getHp());
    }
}