package com.Grupp25.app;

import com.Grupp25.app.board.Textures.TextureHandler;
import com.Grupp25.app.gameengine.GameEngine;
import com.Grupp25.app.item.Weapon;
import com.Grupp25.app.board.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.nio.charset.IllegalCharsetNameException;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Setup extends JFrame {

    private String playerName;
    private Weapon [] startingWeapons;
    private Weapon selectedWeapon;
    private int boardWidth;
    private int boardHeight;
    public String currentState;

    public Setup(){
        startingWeapons = new Weapon [6];
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.add(new JButton("Start game"));
        this.add(new JButton("Game setup"));
        this.setMinimumSize(new Dimension(200, 100));
        this.setPreferredSize(new Dimension(200, 100));
        generateStartingWeapons();
    }

    public void choosePlayerName(){
        this.currentState = "choosePlayerName";
    }

    public void setPlayerName(String name){
        if (checkValidName(name))
            this.playerName = name;
        else
            throw new IllegalArgumentException("Invalid name!");
    }

    public String getPlayerName(){
        return this.playerName;
    }

    private boolean checkValidName(String name){
        if (name.length() > 13)
            return false;
        else if (!name.chars().allMatch(Character::isLetter))
            return false;    
        else if (name.isEmpty())
            return false;
        return true;
    }

    public void chooseWeapon(){
        this.currentState = "chooseWeapon";
    }

    public void goBack(){
        switch(currentState){
            case("choosePlayerName"):
                break;
            case("chooseWeapon"):
                choosePlayerName();
                break;
            case("chooseGameParameters"):
                chooseWeapon();
                break;
        }
    }

    public Weapon selectWeapon(String weapon){
        for (Weapon w : startingWeapons)
            if (w != null && w.getName() == weapon){
                return w;
            }
        return null;
    }

    public void chooseGameParameters(){
        this.currentState = "chooseGameParameters";
    }

    public Board inputGameParameters(int width, int height){
        if (checkParameterBounds(width) && checkParameterBounds(height)){
            return new Board(width, height);
        }
        else
            throw new IllegalArgumentException("Board dimensions out of bounds");
    }

    private boolean checkParameterBounds(int i){
        if (0 < i && i < 50)
            return true;
        else
            return false;
    }

    // Starting equipment
    // Rock is placeholder texture
    private void generateStartingWeapons(){
        TextureHandler textureHandler = new TextureHandler();
        TileGraphics t = new TileGraphics(Color.BLACK, textureHandler.getRockTexture());
        startingWeapons[0] = new Weapon(8, 0, 1, t, "Wood sword");
        startingWeapons[1] = new Weapon(5, 0, 2, t, "Wood spear");
    }
    

}
