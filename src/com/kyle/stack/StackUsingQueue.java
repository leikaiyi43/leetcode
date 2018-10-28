package com.kyle.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {


    static class MyStack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (!q1.isEmpty()) {
                q2.add(x);
                q2.addAll(q1);
                q1.clear();
            } else {
                q1.add(x);
                q1.addAll(q2);
                q2.clear();
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q1.isEmpty() ? q2.poll() : q1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q1.isEmpty() ? q2.peek() : q1.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);

        System.out.println("top=" + obj.top());
        System.out.println("pop=" + obj.pop());
        System.out.println("isEmpty=" + obj.empty());
        System.out.println("pop=" + obj.pop());
        System.out.println("isEmpty=" + obj.empty());
    }


}
