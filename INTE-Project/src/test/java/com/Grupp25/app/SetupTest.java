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
        setup.setPlayerName("h3man");
     }

     @Test (expected = NullPointerException.class)
     public void nameIsNull(){

     }

     @Test (expected = Exception.class)
     public void nameIsTooLong(){

     }

}