package com.Grupp25.app.board;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Image;

import com.Grupp25.app.board.Textures.TextureHandler;
import com.Grupp25.app.board.Tile;

import org.junit.Before;
import org.junit.Test;

public class TileTest {


    Tile testTile;
    Image image;
    TextureHandler textureHandler;
    TileGraphics tileGraphics;

    @Before
    public void tileTestSetup(){
        textureHandler = new TextureHandler();
        tileGraphics = new TileGraphics(new Color(0, 200, 0), textureHandler.getGrassTexture());
        testTile = new Tile(1, false, tileGraphics);
    }

    @Test
    public void testGetSpeedMultiplier(){
        assertEquals(1, testTile.getSpeedMultiplier(), 0);
    }

    @Test
    public void testGetBlocking(){
        assertFalse(testTile.getBlocking());
    }

    @Test
    public void testGetGraphics(){
        assertEquals(tileGraphics, testTile.getGraphics());
    }

   

}