package org.bolin.algorithm.Tree.binaryTreeProperty.L104maxDepth;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L104_250601_1 {

    int maxDepth=0;
    int lowDepth=Integer.MAX_VALUE;

    public void traversal(int depth,TreeNode root){

        if(root==null){
            return  ;
        }
        depth++;
        if(root.left==null&&root.right==null){
            lowDepth=Math.min(depth,lowDepth);
        }
        maxDepth=Math.max(maxDepth,depth);

        traversal(depth,root.left);
        traversal(depth,root.right);
    }

    public int maxDepth(TreeNode root) {
//        注意临界处理啊
        if(root==null){
            return 0;
        }
        traversal(0,root);
        return maxDepth;
    }
}
