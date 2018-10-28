package com.kyle.linkedlist;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode startPrev = null;

        int k = n - m;
        while (curr != null && --m > 0) {
            startPrev = curr;
            curr = curr.next;
        }

        ListNode prev = curr;
        curr = curr.next;

        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (startPrev == null) {
            head.next = curr;
            head = prev;
        } else {
            startPrev.next.next = curr;
            startPrev.next = prev;
        }

        return head;
    }

    public ListNode reverseBetweenOptimize(ListNode head, int m, int n) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 0; i < m-1; i++)
            prev = prev.next;

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n-m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
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
        printLinkedList(new ReverseLinkedList2().reverseBetweenOptimize(head, 1, 5));

    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("null");
    }

}
