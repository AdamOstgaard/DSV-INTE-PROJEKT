package com.Grupp25.app;

import com.Grupp25.app.Setup;

import static org.junit.Assert.*;

import java.lang.instrument.IllegalClassFormatException;
import java.util.IllegalFormatException;

import org.junit.Test;
import org.junit.Before;


public class SetupTest {

    Setup setup;

    @Before
    public void setUp(){
        setup = new Setup();
    }

     @Test (expected = Exception.class)
     public void illegalCharactersInName(){
        setup.setPlayerName("hunter S");
     }

     @Test (expected = Exception.class)
     public void numbersInName(){
         setup.setPlayerName("hunter2");
     }

     @Test (expected = Exception.class)
     public void nameIsNull(){
        setup.setPlayerName("");
     }

     @Test (expected = Exception.class)
     public void nameIsTooLong(){
        setup.setPlayerName("Longinamninenden");
     }

     @Test
     public void selectWoodSword(){
         
         assertNotNull(setup.selectWeapon("Wood sword"));
     }
     



}