package com.kyle.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParenthese {

    static class Solution {
        private static final Map<Character, Character> PARENTHESES;
        static {
            PARENTHESES = new HashMap<>();
            PARENTHESES.put(')', '(');
            PARENTHESES.put(']', '[');
            PARENTHESES.put('}', '{');
        }

        // time-complexity: O(n), space-complexity: O(n)
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if(PARENTHESES.values().contains(c)) {
                    stack.push(c);
                } else if (!stack.isEmpty() && PARENTHESES.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().isValid("(([]))"));
        System.out.println(new Solution().isValid("))"));
        System.out.println(new Solution().isValid("(([])))"));
        System.out.println(new Solution().isValid("(([{]}))"));
        System.out.println(new Solution().isValid("(((([]))"));
    }

}
