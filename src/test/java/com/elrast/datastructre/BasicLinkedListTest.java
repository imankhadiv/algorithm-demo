package com.elrast.datastructre;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BasicLinkedListTest {

    private BasicLinkedList<Integer> basicLinkedList;

    @Before
    public void setUp() {
        basicLinkedList = new BasicLinkedList<>();
    }


    @Test
    public void shouldReturnZeroWhenListIsEmpty() {

        assertEquals(0, basicLinkedList.size());
    }

    @Test
    public void shouldRetrunSizeOfList() {
        basicLinkedList.add(0);
        System.out.println(basicLinkedList);
        assertEquals(1, basicLinkedList.size());
    }

    @Test
    public void shouldRetrunsEqualFirstAndLastNodeWhenThereIsOneNode() {

        basicLinkedList.add(0);
        assertTrue(basicLinkedList.first == basicLinkedList.last);
    }

    @Test
    public void shouldChangeTheLastNodeToTheNewNode() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        BasicLinkedList.Node lastNode = basicLinkedList.last;

        assertTrue((Integer) lastNode.value == 1);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowsExceptionWhenRemovingFromTheEmptyList() {

        basicLinkedList.remove();
    }

    @Test
    public void shouldReturnFirstValueFromListAndDecreasTheSize() {
        basicLinkedList.add(10);
        assertTrue(basicLinkedList.size() == 1);
        assertTrue(10 == (Integer) basicLinkedList.remove());
        assertTrue(basicLinkedList.size() == 0);
    }

    @Test
    public void shouldRemoveLastlementWhenListHasOnlyOneElement() {
        basicLinkedList.add(0);
        basicLinkedList.remove();
        assertTrue(basicLinkedList.first == null);
        assertTrue(basicLinkedList.last == null);

    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenInsertingNewItemAtWrongPosition() {

        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.insert(3, 3);
    }

    @Test
    public void shouldInsertItemAtPosition() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.insert(10, 1);

        assertTrue(basicLinkedList.first.value == 0);
        assertTrue(basicLinkedList.last.value == 1);
        assertTrue(basicLinkedList.size() == 3);

    }

    @Test
    public void shouldModifyFirstElementWhenInsertingAtIndexZero() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.insert(10, 0);

        assertTrue(basicLinkedList.first.value == 10);
        assertTrue(basicLinkedList.last.value == 1);
        assertTrue(basicLinkedList.first.nextNode.value == 0);
    }

    @Test
    public void shouldModifyFirstWhenRemovingFirstNode() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        Integer value = basicLinkedList.removeAt2(0);

        assertTrue(basicLinkedList.first.getValue() == 1);
        assertTrue(value == 0);
        assertTrue(basicLinkedList.size() == 1);
    }

    @Test
    public void shouldModifyLastWhenRemovingLastNode() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        Integer value = basicLinkedList.removeAt(1);

        assertTrue(basicLinkedList.first.getValue() == 0);
        assertTrue(value == 1);
        assertTrue(basicLinkedList.size() == 1);
        assertTrue(basicLinkedList.last.getValue() == 0);
    }

    @Test
    public void shouldAddItemWhenIndexIsEqualSize() {
        basicLinkedList.add(10);
        basicLinkedList.add(20);
        basicLinkedList.add(30);
        basicLinkedList.insert(500, 3);
        assertTrue(basicLinkedList.size() == 4);
        assertTrue(basicLinkedList.last.getValue() == 500);
    }

    @Test
    public void shouldGetNodeAtPosition() {
        basicLinkedList.add(10);
        basicLinkedList.add(20);
        basicLinkedList.add(30);
        assertTrue(basicLinkedList.get(0) == 10);
        assertTrue(basicLinkedList.get(1) == 20);
        assertTrue(basicLinkedList.get(2) == 30);
    }

    @Test
    public void shouldFindItem() {
        basicLinkedList.add(10);
        basicLinkedList.add(20);
        basicLinkedList.add(30);
        assertTrue(basicLinkedList.find(10) == 0);
        assertTrue(basicLinkedList.find(20) == 1);
        assertTrue(basicLinkedList.find(30) == 2);

    }

    @Test
    public void shouldRetunMinusOneIfItemIsNotValid() {
        basicLinkedList.add(10);
        assertTrue(basicLinkedList.find(30) == -1);
    }

    @Test
    public void shouldRemoveDuplicateNodesWithBuffer() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.add(2);
        basicLinkedList.add(3);
        basicLinkedList.add(4);
        basicLinkedList.add(3);
        basicLinkedList.add(3);
        basicLinkedList.add(3);


        System.out.println(basicLinkedList);
        basicLinkedList.removeDuplicatesWithBuffer(basicLinkedList.first);
        System.out.println(basicLinkedList);
        assertEquals(5, basicLinkedList.size());

    }

    @Test
    public void shouldRemoveDuplicateWithoutBuffer() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.add(2);
        basicLinkedList.add(3);
        basicLinkedList.add(4);
        basicLinkedList.add(3);
        basicLinkedList.add(3);
        basicLinkedList.add(3);


        System.out.println(basicLinkedList);
        basicLinkedList.removeDuplicateWithoutBuffer(basicLinkedList.first);
        System.out.println(basicLinkedList);
        assertEquals(5, basicLinkedList.size());
    }
    @Test
    public void shouldFindKethNodeToEnd() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.add(2);
        basicLinkedList.add(3);
        basicLinkedList.add(4);

        System.out.println(basicLinkedList);
        BasicLinkedList.Node node = basicLinkedList.findKthNodeToTheEnd(basicLinkedList.first,1);
        assertEquals(4, node.value);
    }
    @Test
    public void shouldFindKethNodeToEndWithRecursiveApproach() {
        basicLinkedList.add(0);
        basicLinkedList.add(1);
        basicLinkedList.add(2);
        basicLinkedList.add(3);
        basicLinkedList.add(4);

        System.out.println(basicLinkedList);
        BasicLinkedList.Node node = basicLinkedList.findKthNodeToTheEndWithRecursiveApproach(basicLinkedList.first,2);
        assertEquals(3, node.value);
    }

}