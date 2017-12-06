package com.elrast;

import com.elrast.datastructre.BasicLinkedList;

import java.util.HashSet;
import java.util.Set;

public class LNode {

    int val;
    LNode next;

    LNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("");
        LNode n = this;
        while (n != null) {
            s.append(n.val);
            s.append("->");
            n = n.next;
        }

        return s.subSequence(0, s.length() - 2).toString();
    }

    LNode removeDuplicates(LNode node) {
        LNode first = node;
        LNode previous = node;
        Set<Integer> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node.val)) {
                previous.next = node.next;
            } else {
                set.add(node.val);
                previous = node;
            }
            node = node.next;
        }
        return first;
    }

    LNode removeDuplicatesWithoutBuffere(LNode node) {

        LNode first = node;
        while (node != null) {

            LNode runner = node.next;
            LNode previous = node;
            while (runner != null) {

                if (runner.val == node.val) {
                    previous.next = runner.next;
                } else {
                    previous = runner;
                }
                runner = runner.next;
            }
            node = node.next;
        }
        return first;
    }


    public int findKthToTheLastElement(LNode node, int k) {

        if (node == null) return 0;

        int i = findKthToTheLastElement(node.next, k) + 1;
        if (i == k) {
            System.out.println("this is where k is supposed to be");
            System.out.println(node.val);
        }
        return i;

    }

    public int findSize(LNode node) {

        if (node == null) return 0;
        return findSize(node.next) + 1;
    }

    LNode partition(LNode node, int x) {

        LNode head = node;
        LNode tail = node;
        System.out.println(head);
        System.out.println(tail);
        node = node.next;
        while (node != null) {
            LNode next = node.next;
            if (node.val <= x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            //node = next;
            node = node.next;
        }
        tail.next = null;
        return head;
    }


    public static LNode removeDuplicateOptimised(LNode first) {

        LNode node = first;
        while (node != null) {

            LNode runner = node.next;
            LNode previous = node;

            while (runner != null) {

                if (Integer.compare(node.val, runner.val) == 0) {
                    previous.next = runner.next;
                } else {
                    previous = runner;
                }
                runner = runner.next;
            }
            node = node.next;
        }
        return first;
    }



}
