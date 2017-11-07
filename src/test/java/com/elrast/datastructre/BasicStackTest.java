package com.elrast.datastructre;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicStackTest {

    BasicStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new BasicStack<>();
    }

    @Test
    public void shouldPushToTheStack() {
        stack.push(10);
        assertTrue(stack.contains(10));
    }

    @Test
    public void shouldPopFromStack() {
        stack.push(10);
        stack.push(20);
        assertTrue(20 == stack.pop());

    }

    @Test
    public void shouldCheckIfStackContainsAnElement() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.contains(3));
        assertFalse(stack.contains(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsExceptionFooGettingInvalidItemOnTheStack() {

        stack.push(10);
        stack.access(12);
    }

    @Test
    public void shouldAccessItemInTheStack() {

        stack.push(1);
        assertTrue(stack.access(1) == 1);

    }

}