package com.kyle.bst;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfTree {

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 1;
            while (true) {
                int levelCount = queue.size();
                while(levelCount-- > 0) {
                    TreeNode head = queue.poll();
                    if (head.left == null && head.right == null) return depth;
                    if (head.left != null) queue.add(head.left);
                    if (head.right != null) queue.add(head.right);
                }
                depth ++;
            }
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
