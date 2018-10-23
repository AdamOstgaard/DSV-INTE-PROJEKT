package com.Grupp25.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

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

    private void choosePlayerClass(){

    }

    private void chooseGameParameters(){

    }

}
