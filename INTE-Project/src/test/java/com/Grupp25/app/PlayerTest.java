package com.Grupp25.app;

import com.Grupp25.app.board.Board;
import com.Grupp25.app.board.Position;
import com.Grupp25.app.characters.Player;
import com.Grupp25.app.gameengine.GameEngine;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Player player;
    Board board;
    GameEngine game;

    @Before
    public void setUP(){
    player = new Player();
    board = new Board();
    game = (new GameEngine(board));
    }

    @Test
    public void testLevelUp() {
        player.levelUp();
        assertEquals(2, player.getLevel());
    }
    
    @Test
    public void LevelUpMaxHpTest() {
        player.levelUp();
        assertEquals(105, player.getMaxHp());
    }

    @Test
    public void LevelUpStrengthTest() {
        player.levelUp();
        assertEquals(17, player.getStrength());
    }

    @Test
    public void LevelUpDefenseTest() {
        player.levelUp();
        assertEquals(12, player.getDefense());
    }

    @Test
    public void LevelUpSpeedTest() {
        player.levelUp();
        assertEquals(4, player.getSpeed());
    }

    @Test
    public void LevelUpAccuracyTest() {
        player.levelUp();
        assertEquals(3, player.getAccuracy());
    }

    @Test
    public void gainXpTest(){
        player.gainXp(20);
        assertEquals(20, player.getXp());
    }

    @Test
    public void moveTest(){
        game.getPlayer().move(board, Direction.west);
        assertEquals(board.getItemAt(4, 5), game.getPlayer());
    }

    @Test
    public void moveEastTest(){
        game.getPlayer().move(board, Direction.east);
        assertEquals(board.getItemAt(5, 5), game.getPlayer());
    }

    @Test
    public void getGraphicsTest(){
        JLabel graphics = new JLabel();
        player.setGraphics(graphics);
        assertEquals(graphics, player.getGraphics());
    }
}