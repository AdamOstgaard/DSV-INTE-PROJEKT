package com.Grupp25.app;

import com.Grupp25.app.Setup;
import com.Grupp25.app.board.Board;

import static org.junit.Assert.*;

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
     public void nameIsValid(){
         setup.setPlayerName("niklas");
         assertEquals("niklas", setup.getPlayerName());
         setup.chooseWeapon();
     }

     @Test
     public void selectWoodSword(){
         
         assertNotNull(setup.selectWeapon("Wood sword"));
         setup.chooseGameParameters();
     }

     @Test
     public void selectInvalidWeapon(){
         assertNull(setup.selectWeapon("weapon"));
     }

     @Test
     public void testCurrentState(){
         setup.choosePlayerName();
         assertEquals("choosePlayerName", setup.currentState);
         setup.chooseWeapon();
         assertEquals("chooseWeapon", setup.currentState);
         setup.chooseGameParameters();
         assertEquals("chooseGameParameters", setup.currentState);
     }
     
     @Test
     public void goBackFromStateTest(){
         setup.chooseGameParameters();
         setup.goBack();
         assertEquals("chooseWeapon", setup.currentState);
         setup.goBack();
         assertEquals("choosePlayerName", setup.currentState);
         setup.goBack();
         assertEquals("choosePlayerName", setup.currentState);
     }

     @Test (expected = Exception.class)
     public void testOutofBoundsGameParameters(){
        setup.inputGameParameters(100, 49);
     }

     @Test
     public void testValidGameParameters(){
        Board newBoard = setup.inputGameParameters(20, 30);
        assertEquals(new Board(20, 30).getWidth(), newBoard.getWidth());
        assertEquals(new Board(20, 30).getHeight(), newBoard.getHeight());

     }

}