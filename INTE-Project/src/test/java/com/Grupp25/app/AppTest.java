package com.Grupp25.app;

import com.Grupp25.app.Setup;
import com.Grupp25.app.App;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.Test;
import org.junit.Before;

public class AppTest {


    @Test
    public void appTest(){
        assertNotNull(new App());
    }

}
