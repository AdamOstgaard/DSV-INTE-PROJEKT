package com.Grupp25.app.item;
import com.Grupp25.app.characters.*;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import org.junit.Before;
import org.junit.Test;

public class ConsumableTest {

    Consumable consumable;
    Player player;
    JLabel icon;

    @Before
    public void setUp() {
		consumable = new Consumable(50, 1, icon, "Potato Juice");
        player = new Player();
    }

    @Test
    public void getHealingPower() {
        assertEquals(50, consumable.getHealingPower());
    }

    @Test
    public void consumeTest(){
        consumable.consume(player);
        assertEquals(150, player.getHp());
    }

    
    }
