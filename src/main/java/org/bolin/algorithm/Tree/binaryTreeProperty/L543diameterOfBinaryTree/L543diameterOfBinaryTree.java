package org.bolin.algorithm.Tree.binaryTreeProperty.L543diameterOfBinaryTree;


import org.bolin.algorithm.Tree.model.TreeNode;

class L543diameterOfBinaryTree_250720_1{
    int maxValue=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode root){
        if(root==null){
            return -1;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
//       最大值不一定会经过根节点的啊
        maxValue=Math.max(leftHeight+rightHeight+2,maxValue);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
public class L543diameterOfBinaryTree {
}
