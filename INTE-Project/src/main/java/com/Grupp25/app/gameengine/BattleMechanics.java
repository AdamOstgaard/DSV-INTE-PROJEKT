package com.Grupp25.app.gameengine;

import com.Grupp25.app.characters.*;
import com.Grupp25.app.board.*;

public class BattleMechanics{

    public BattleMechanics(){
    }

    public BoardItem fire(Player player, Board board){
        Position playerPos = board.getItemPosition(player);
        // int maxRange = player.getMaxRange();
        // int minRange = player.getMinRange();
        int maxRange = 4;
        int minRange = 2;
        Position hitPos = playerPos;
        BoardItem item;
        for (int i = 0; i < minRange; i++){
            hitPos = board.getNextPosition(player.getDirection(), hitPos);
        }
        for (int i = 0; i <= maxRange - minRange; i++){
            item = board.getItemAt(hitPos.getX(), hitPos.getY());
            if (item instanceof Enemy){
                System.out.print("hej");
                return item;
            }
            hitPos = board.getNextPosition(player.getDirection(), hitPos);
        }
        System.out.println(hitPos.getX() + " " + hitPos.getY());
        return null;
    }
}