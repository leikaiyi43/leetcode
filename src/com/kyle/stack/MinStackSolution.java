package com.kyle.stack;

import com.sun.jdi.connect.Connector;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStackSolution {


    static class MinStack {

        private Stack<Integer> stack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            int min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            min = min < x ? min : x;
            stack.push(x);
            stack.push(min);
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty())
                throw new RuntimeException("invalid operation");

            int min = stack.pop();
            int ret = stack.peek();
            stack.push(min);
            return ret;
        }

        public int getMin() {
            return stack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-1);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());



    }



}
