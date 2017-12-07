package com.elrast;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LNodeTest {


    @Test
    void shouldRemoveDuplicates() {

        LNode node = new LNode(1);
        LNode first = node;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(5);
        node = node.next;

        System.out.println(first);
        first.removeDuplicates(first);
        System.out.println(first);
        assertEquals(3, first.next.next.val);
    }

    @Test
    void shouldRemoveDuplicatesWithoutBuffer() {
        LNode node = new LNode(1);
        LNode first = node;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(5);
        node = node.next;

        System.out.println(first);
        first.removeDuplicatesWithoutBuffere(first);
        System.out.println(first);

        assertEquals(3, first.next.next.val);
    }
    @Test
    void shouldFindListSize() {
        LNode node = new LNode(1);
        LNode first = node;
        node.next = new LNode(2);
        assertEquals(2, node.findSize(node));
    }
    @Test
    void shouldFindKthToLastElement() {
        LNode node = new LNode(1);
        LNode first = node;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(10);
        node = node.next;
        node.next = new LNode(20);
        System.out.println(first);
        //assertEquals(2, node.findSize(node));

        int kth = node.findKthToTheLastElement(first, 2);
        System.out.println("..." + kth);

    }

    @Test
    void shouldPartitaionNode() {

        LNode node = new LNode(8);
        LNode first = node;
        node.next = new LNode(2);
        node = node.next;
//        node.next = new LNode(8);
//        node = node.next;
        node.next = new LNode(15);

        System.out.println(first.partition(first,3));
    }

    @Test
    void shouldRemoveDuplicatesNodes() {

        LNode node = new LNode(1);
        LNode first = node;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(2);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(3);
        node = node.next;
        node.next = new LNode(5);
        node = node.next;

        System.out.println(first);

        System.out.println(LNode.removeDuplicateOptimised(first));


        char ch = 'a';
        int i = (int)ch;
        System.out.println(ch);
        System.out.println(i);
        System.out.println('z' - 'a');
    }

}