package com.elrast;


public class AddTwoNumber {
    public class ListNode {

        int val;
        ListNode next;

        ListNode(Integer val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        int carrier = 0;
        while (l1 != null || l2 != null) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l1 != null ? l1.val : 0;
            int sum = val1 + val2;

            ListNode listNode = new ListNode((sum + carrier) % 10);
            carrier = (sum + carrier) / 10;
            pointer.next = listNode;
            pointer = pointer.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }
}
