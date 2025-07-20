package org.bolin.algorithm.Tree.binarySortTree.KthSmallest_L230;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L230kthSmallest {

    int tmpSequence=0;

    public int kthSmallest(TreeNode root, int k) {
        return traversal(root,k);
    }

    private int  traversal(TreeNode root,int k){
        if(root==null){
            return -1;
        }
        int leftValue = traversal(root.left, k);
//       注意是大于等于0啊
        if( leftValue>=0){
            return  leftValue;
        }

        tmpSequence++;
        if(tmpSequence==k){
            return root.val;
        }
        return traversal(root.right,k);


    }
}
