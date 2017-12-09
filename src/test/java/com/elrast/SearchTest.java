package com.elrast;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    private Search app;

    @BeforeEach
    void setUp() {
        app = new Search();
    }

    @Test
    void shouldFindThePoint() {

        int[] input = {1,3,4,10,20,33,40};
        int point = 33;
        Assert.assertTrue(app.findPointRecursively(input,point));
    }
    @Test
    void shouldNotFindThePoint() {

        int[] input = {1,3,4,10,20,33,40};
        int point = 100;
        Assert.assertFalse(app.findPointRecursively(input,point));
    }
    @Test
    void shouldNotFindThePointUsingIteration() {

        int[] input = {1,3,4,10,20,33,40};
        int point = 100;
        Assert.assertFalse(app.findPointUsingIteration(input,point));
    }
    @Test
    void shouldFindThePointUsingIteration() {

        int[] input = {1,3,4,10,20,33,40};
        int point = 33;
        Assert.assertTrue(app.findPointUsingIteration(input,point));
    }

}