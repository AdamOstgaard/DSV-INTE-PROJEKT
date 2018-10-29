package com.Grupp25.app;

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
    private Enum Class;
    private int boardWidth;
    private int boardHeight;
    private int tickRate;

    public Setup(){
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.add(new JButton("Start game"));
        this.add(new JButton("Game setup"));
        this.setMinimumSize(new Dimension(200, 100));
        this.setPreferredSize(new Dimension(200, 100));
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
        else if (name.contains(" "))
            return false;
        return true;
    }

    private void choosePlayerClass(){

    }

    private void chooseGameParameters(){

    }

}
