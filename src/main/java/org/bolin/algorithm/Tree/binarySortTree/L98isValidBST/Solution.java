package org.bolin.algorithm.Tree.binarySortTree.L98isValidBST;

import org.bolin.algorithm.Tree.model.TreeNode;

class Solution {
    // 递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);  // ❌ 这个值小于10，违反BST规则
        root.right.right = new TreeNode(20);

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));  // 应该输出 false
    }
}