package com.kyle.bst;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTree {

    static class Solution {

        public int numTrees(int n) {
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(1));
        System.out.println(solution.numTrees(2));
        System.out.println(solution.numTrees(3));
    }

}
