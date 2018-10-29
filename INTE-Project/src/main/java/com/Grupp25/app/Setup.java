package com.Grupp25.app;

import com.Grupp25.app.board.Textures.TextureHandler;
import com.Grupp25.app.item.Weapon;


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
    private int tickRate; 

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

    private void choosePlayerName(){

    }

    public void setPlayerName(String name){
        if (checkValidName(name))
            this.playerName = name;
        else
            throw new IllegalArgumentException("Invalid name!");
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

    private void weaponSelection(){

    }

    public Weapon selectWeapon(String weapon){
        for (Weapon w : startingWeapons)
        if (w.getName() == weapon){
            return w;
        }
    return null;
    }

    private void chooseGameParameters(){

    }

    // Starting equipment
    private void generateStartingWeapons(){
        TextureHandler textureHandler = new TextureHandler();
        startingWeapons[0] = new Weapon(8, 0, 1, textureHandler.getRockTexture(), "Wood sword");
        startingWeapons[1] = new Weapon(5, 0, 2, null, "Wood spear");
    }
    

}
