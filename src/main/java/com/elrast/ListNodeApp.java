package com.elrast;

class ListNode {

    int val;
    ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        String s = val + "->";
        ListNode tmp = this;
        while (tmp.next != null) {
            s += tmp.val + "->";
            tmp = tmp.next;
        }
        return s+= tmp.val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;
        ListNode temp = this;
        ListNode temp1 = listNode;

        if (temp.val != temp1.val) return false;
        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.next;
            if(temp.val != temp1.val){
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}

public class ListNodeApp {


    public ListNode plusOneON(ListNode head) {
        long start = System.currentTimeMillis();
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        head = pointer;
        boolean has9 = false;
        ListNode tmp = null;
        ListNode divertion = null;
        ListNode divertionHead = null;

        while (pointer.next != null) {
            if (pointer.next.val == 9) {
                has9 = true;
                if (tmp == null) {
                    tmp = pointer;
                    divertion = new ListNode(0);
                    divertionHead = divertion;

                } else {
                    divertion.next = new ListNode(0);
                    divertion = divertion.next;
                }
            } else {
                tmp = null;
                has9 = false;
                divertion = null;
            }
            pointer = pointer.next;
        }
        if (has9) {
            tmp.val += 1;
            tmp.next = divertionHead;
            if (head.val == 0) head = head.next;

        } else {
            pointer.val += 1;
            head = head.next;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return head;

    }

    public ListNode plusOneN2(ListNode head) {
        long start = System.currentTimeMillis();
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        head = pointer;
        boolean has9 = false;
        ListNode tmp = null;

        while (pointer.next != null) {

            if (pointer.next.val == 9) {
                has9 = true;
                if (tmp == null) tmp = pointer;
            } else {
                tmp = null;
                has9 = false;
            }
            pointer = pointer.next;
        }
        if (has9) {
            tmp.val += 1;
            while (tmp.next != null) {
                tmp.next.val = 0;
                tmp = tmp.next;
                if (head.val == 0) head = head.next;
            }
            tmp.val = 0;
        } else {
            pointer.val += 1;
            head = head.next;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return head;
    }
}
