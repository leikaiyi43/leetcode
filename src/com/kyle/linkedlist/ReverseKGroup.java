package com.kyle.linkedlist;

import java.util.List;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode lookup = head;
        ListNode prev = dummy;
        ListNode start = dummy.next;
        ListNode then = start.next;
        int i = 1;
        while (lookup != null) {
            lookup = lookup.next;
            if (i++ % k == 0) {
                while (lookup != then) {
                    start.next = then.next;
                    then.next = prev.next;
                    prev.next = then;
                    then = start.next;
                }

                if (then != null) {
                    prev = start;
                    start = then;
                    then = then.next;
                }
            }
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i ++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        printLinkedList(head);
        printLinkedList(new ReverseKGroup().reverseKGroup(head, 3));

    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("null");
    }
}
