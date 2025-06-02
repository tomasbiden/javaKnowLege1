package org.bolin.algorithm.Tree.binaryTreeProperty.L101isSymmetric;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L101_250601_1 {

    public boolean traversal(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return  true;
        }
        if((left!=null&&right!=null&&left.val==right.val)){
                boolean first=traversal(left.left,right.right);
                boolean secode=traversal(left.right,right.left);
                return first&&secode;
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return  traversal(root.left,root.right);
    }
}
