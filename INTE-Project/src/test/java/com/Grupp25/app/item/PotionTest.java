package com.Grupp25.app.item;
import com.Grupp25.app.characters.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PotionTest {

    Potion potion;
    Player player;

    @Before
    public void setUp() {
        potion = new Potion(50, 1);
        player = new Player();
    }

    @Test
    public void getHealingPower() {
        assertEquals(50, potion.getHealingPower());
    }

    @Test
    public void consumeTest(){
        potion.consume(player);
        assertEquals(150, player.getHp());
    }

    
    }
