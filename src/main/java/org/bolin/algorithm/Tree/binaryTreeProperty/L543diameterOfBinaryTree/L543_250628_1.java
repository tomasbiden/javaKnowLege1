package org.bolin.algorithm.Tree.binaryTreeProperty.L543diameterOfBinaryTree;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L543_250628_1
{

    public int  getHeight(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        int leftHeight=getHeight(treeNode.left);
        int rightHeight=getHeight(treeNode.right);
        return  Math.max(leftHeight,rightHeight)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter  = diameterOfBinaryTree(root.right);
        int rootDiameter=getHeight(root.left)+getHeight(root.right);
        return Math.max(Math.max(leftDiameter,rightDiameter),rootDiameter);

    }
}
