package com.Grupp25.app.gameengine;

import com.Grupp25.app.characters.*;
import com.Grupp25.app.board.*;
import com.Grupp25.app.characters.GameCharacter;
import java.util.Random;

public class BattleMechanics {

    private Random rand;

    public BattleMechanics() {
        rand = new Random();
    }

    public GameCharacter runBattle(GameCharacter attacker, Board board) {
        GameCharacter target = searchTarget(attacker, board);
        if (target == null)
            return null;
        if (determineHit(attacker, target) == true) {
            determineDamage(attacker, target);
            return target;
        } else
            return null;
    }
 
    // Tillfällig överskuggning innan random är implementerad i test.
    public GameCharacter runBattle(GameCharacter attacker, Board board, int i) {
        GameCharacter target = searchTarget(attacker, board);
        if (target == null)
            return null;
        if (determineHit(attacker, target, i) == true) {
            determineDamage(attacker, target);
            return target;
        } else
            return null;
    }

    public GameCharacter searchTarget(GameCharacter attacker, Board board) {
        Position attackerPos = board.getItemPosition(attacker);
        int maxRange = attacker.getMaxAttackRange();
        int minRange = attacker.getMinAttackRange();
        Position hitPos = attackerPos;
        BoardItem hitTarget;
        for (int i = 0; i < minRange; i++) {
            hitPos = board.getNextPosition(attacker.getDirection(), hitPos);
        }
        for (int i = 0; i <= maxRange - minRange; i++) {
            hitTarget = board.getItemAt(hitPos.getX(), hitPos.getY());
            if (hitTarget == null) {
                continue;
            }
            if ((attacker instanceof Player && hitTarget instanceof Enemy)
                    || (attacker instanceof Enemy && hitTarget instanceof Player))
                return (GameCharacter) hitTarget;
            hitPos = board.getNextPosition(attacker.getDirection(), hitPos);
        }
        return null;
    }

    // Tänker att chansen ska modifieras baserat på statsen.
    private boolean determineHit(GameCharacter attacker, GameCharacter target) {
        int dice = rand.nextInt(20) + 1;
        if (dice > 2)
            return true;
        else
            return false;
    }

    // Tillfällig överskuggning innan random är implementerad i test.
    public boolean determineHit(GameCharacter attacker, GameCharacter target, int slump) {
        if (slump > 2)
            return true;
        else
            return false;
    }

    // Tänker att chansen ska modifieras baserat på statsen.
    private void determineDamage(GameCharacter attacker, GameCharacter target) {
        int dice = rand.nextInt(20) + 1;
        int damageDealt = dice + attacker.getStrength() - target.getDefense();
        if (damageDealt < 1)
            damageDealt = 1;
        target.setHp(target.getHp() - damageDealt);
    }

    // Tillfällig överskuggning innan random är implementerad i test.
    public void determineDamage(GameCharacter attacker, GameCharacter target, int slump) {
        int damageDealt = slump + attacker.getStrength() - target.getDefense();
        if (damageDealt < 1)
            damageDealt = 1;
        target.setHp(target.getHp() - damageDealt);
    }

}