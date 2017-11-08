package com.elrast.datastructre;

import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicQueueTest {

    BasicQueue<Integer> basicQueue;

    @Before
    public void setUp() throws Exception {
        basicQueue = new BasicQueue<>(2);
    }

    @Test
    public void shouldReturnSize() {

        Assert.that(basicQueue.size() == 0, "Empty queue has a size of zero");
        basicQueue.enQueue(1);
        assertTrue(basicQueue.size() == 1);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldAddItemToQueue() {

        basicQueue.enQueue(10);
        basicQueue.enQueue(20);
        basicQueue.enQueue(30);
    }

    @Test
    public void shouldDequeItem() {

        basicQueue.enQueue(10);
        basicQueue.deQueue();
        assertTrue(basicQueue.size() == 0);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToDequeWhenQueueIsEmpty() {

        basicQueue.enQueue(10);
        basicQueue.deQueue();
        basicQueue.deQueue();
    }

    @Test
    public void shouldContainsAnAddedItem() {
        basicQueue.enQueue(20);
        basicQueue.enQueue(30);
        assertTrue(basicQueue.contains(20));
        assertFalse(basicQueue.contains(40));
    }

    @Test
    public void shouldAccessItemWithTheGivenPosition() throws Exception {
        basicQueue.enQueue(10);
        basicQueue.enQueue(20);
        assertTrue(basicQueue.access(1) == 20);
    }

}