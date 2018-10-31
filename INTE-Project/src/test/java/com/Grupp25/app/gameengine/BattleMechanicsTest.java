package com.Grupp25.app.gameengine;

import static org.junit.Assert.*;

import java.util.Random;

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
    public void runBattleTest(){
        game.addEnemy(new Position(4, 5), enemy1);
        battleMechanics.setRandom(new Random(4));
        assertEquals(enemy1, battleMechanics.runBattle(game.getPlayer(), board));
    }

    @Test
    public void runBattleTestNoTarget(){
        assertEquals(null, battleMechanics.runBattle(game.getPlayer(), board));
    }

    @Test
    public void runBattleTestMiss(){
        game.addEnemy(new Position(4, 5), enemy1);
        battleMechanics.setRandom(new Random(15));
        assertEquals(null, battleMechanics.runBattle(game.getPlayer(), board, 2));
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
        //Random.nextInt(20) + 1 = 3
        battleMechanics.setRandom(new Random(4)); 
        assertTrue(battleMechanics.determineHit(game.getPlayer(), enemy1));
    }

    @Test
    public void determineHitTestMiss(){
        //Random.nextInt(20) + 1 = 2
        battleMechanics.setRandom(new Random(15)); 
        assertFalse(battleMechanics.determineHit(game.getPlayer(), enemy1));
    }

    @Test
    public void determineDamageTest(){
        //Random.nextInt(20) + 1 = 6
        battleMechanics.setRandom(new Random(1)); 
        battleMechanics.determineDamage(game.getPlayer(),  enemy1);
        assertEquals(89, enemy1.getHp());
    }

    @Test
    public void getRandomTest(){
        Random rand = new Random();
        battleMechanics.setRandom(rand);
        assertEquals(rand, battleMechanics.getRandom());
    }
}