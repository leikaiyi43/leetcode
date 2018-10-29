package com.kyle.stack;


import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueUsingStack {

    static class MyQueue {

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!output.isEmpty())
                return output.pop();

            while (!input.isEmpty())
                output.push(input.pop());
            return output.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!output.isEmpty())
                return output.peek();

            while (!input.isEmpty())
                output.push(input.pop());

            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
