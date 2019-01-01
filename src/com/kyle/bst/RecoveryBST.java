package com.kyle.bst;

import java.util.ArrayList;
import java.util.List;

public class RecoveryBST {

    class Solution {
        public void recoverTree(TreeNode root) {

            List<TreeNode> candidates = new ArrayList<>();
            checkTree(root, candidates);
            if (!candidates.isEmpty()) {
                TreeNode first = candidates.get(0);
                TreeNode last = candidates.get(candidates.size() - 1);

                // swipe
                int val = first.val;
                first.val = last.val;
                last.val = val;
            }
        }

        private void checkTree(TreeNode root, List<TreeNode> candidates) {
            if (root == null || candidates.size() >= 4)
                return;

            // check left tree
            checkTree(root.left, candidates);

            // check root node
            TreeNode prev = getPrev(root);
            TreeNode next = getNext(root);

            if (prev != null && prev.val > root.val) {
                candidates.add(prev);
                candidates.add(root);
            }

            if (next != null && next.val < root.val) {
                candidates.add(root);
                candidates.add(next);
            }
            // check right tree
            checkTree(root.right, candidates);

        }

        private TreeNode getPrev(TreeNode root) {
            if (root == null)
                return null;

            TreeNode prev = root.left;
            while (prev != null && prev.right != null)
                prev = prev.right;

            return prev;
        }

        private TreeNode getNext(TreeNode root) {
            if (root == null)
                return null;

            TreeNode next = root.right;
            while (next != null && next.left != null)
                next = next.left;

            return next;
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
