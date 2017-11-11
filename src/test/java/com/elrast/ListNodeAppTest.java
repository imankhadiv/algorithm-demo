package com.elrast;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ListNodeAppTest {

    ListNodeApp listNodeApp;

    @Before
    public void setUp() throws Exception {
        listNodeApp = new ListNodeApp();
    }

    @Test
    public void addOne() {

        ListNode listNode = createListNode();
        listNodeApp.plusOneN2(listNode);
        listNodeApp.plusOneON(listNode);

    }

    private ListNode createListNode() {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        for (int i = 0; i < 1000000; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(9, 10);
            ListNode listNode = new ListNode(randomNum);
            temp.next = listNode;
            temp = temp.next;
        }
        return head;
    }

}