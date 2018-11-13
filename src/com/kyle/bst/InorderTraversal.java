package com.kyle.bst;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return Collections.emptyList();

            List<Integer> result = new LinkedList<>();
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
            return result;
        }

        private void inorderTraversal(TreeNode root, List<Integer> result) {
            if (root == null)
                return;
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
