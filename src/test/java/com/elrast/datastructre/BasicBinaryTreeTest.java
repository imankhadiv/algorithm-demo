package com.elrast.datastructre;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicBinaryTreeTest {

    private BasicBinaryTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BasicBinaryTree<>(null);
    }


    @Test
    public void shouldIncreasedTheSizeWhenAddingItem() throws Exception {
        tree.add(10);
        tree.add(20);
        assertEquals(2, tree.size());
    }

    @Test
    public void shouldAddItemsToTheTree() throws Exception {
        tree.add(10);
        assertTrue(tree.contains(10));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionForGettingItemFromEmptyTree() throws Exception {
        tree.contains(10);
    }

    @Test
    public void shouldDeleteItems() throws Exception {

        tree.add(10);
        tree.add(20);
        tree.delete(20);
        assertFalse(tree.contains(20));
    }

    @Test
    public void shouldModifyTheRootAfterRemovingFromTheTree() {
        tree.add(10);
        tree.add(20);
        tree.add(30);
        BasicBinaryTree.Node node = (BasicBinaryTree.Node) tree.getRoot();
        assertTrue(10 == (Integer) node.getItem());
    }
}