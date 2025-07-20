package org.bolin.algorithm.Tree.binaryTreeProperty.L104maxDepth;

import org.bolin.algorithm.Tree.model.TreeNode;

class L104maxDepth_250720_1 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}

public class L104maxDepth {
}
