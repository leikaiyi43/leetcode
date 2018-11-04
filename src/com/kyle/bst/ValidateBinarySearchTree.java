package com.kyle.bst;

import java.util.HashMap;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long min, long max) {
            if (root == null)
                return true;
            if (root.val <= min || root.val >= max)
                return false;

            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
