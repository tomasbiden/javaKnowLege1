package org.bolin.algorithm.Tree.binaryTreeProperty.L110isBalanced;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L110_250601_1 {
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth=getDepth(root.right);
        if((leftDepth==-1)||(rightDepth==-1)||Math.abs(rightDepth-leftDepth)>1){
            return -1;
        }else{
            return Math.max(leftDepth,rightDepth)+1;
        }


    }
    public boolean isBalanced(TreeNode root) {
        return getDepth(root)==-1?false:true;

    }
}
