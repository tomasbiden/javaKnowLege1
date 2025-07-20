package org.bolin.algorithm.Tree.binarySortTree.L98isValidBST;


import org.bolin.algorithm.Tree.model.TreeNode;

class  L98isValidBST_250720_1{

    long preValue=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    private boolean dfs(TreeNode root){
//       注意空处理
        if(root==null){
            return true;
        }
        boolean leftFlag = dfs(root.left);
        if(root.val<=preValue){
            return false;
        }else {
            preValue=root.val;
        }
        boolean rightFlag = dfs(root.right);
        return leftFlag&&rightFlag;


    }
}
public class L98isValidBST {
}
