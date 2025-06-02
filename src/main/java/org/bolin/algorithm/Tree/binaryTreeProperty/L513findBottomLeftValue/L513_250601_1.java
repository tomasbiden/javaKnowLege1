package org.bolin.algorithm.Tree.binaryTreeProperty.L513findBottomLeftValue;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L513_250601_1 {
    int tmpMaxDepth=0;
    int result=0;
    public void traversal(int depth,TreeNode root){
//        注意处理空值
        if(root==null){
            return;
        }
        depth++;
        if(tmpMaxDepth<depth){
            tmpMaxDepth=depth;
            result=root.val;
        }
        traversal(depth,root.left);
        traversal(depth,root.right);


    }

    public int findBottomLeftValue(TreeNode root) {
        traversal(0,root);
        return result;

    }
}
