package com.elrast.datastructre;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BBasicStackWithMinTest {

    BBasicStackWithMin<Integer> app;

    @Before
    public void setUp() {
        app = new BBasicStackWithMin<>();
        System.out.println("app created!");
    }

    @Test
    public void shouldReturnMinimum() {

        app.push(10);
        app.push(20);
        app.push(30);
        app.push(5);
        app.push(9);
        Assert.assertTrue(5 == app.min());
    }

}