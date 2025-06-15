package org.bolin.algorithm.Tree.binarySortTree.L98isValidBST;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L98_250602_1 {
    TreeNode tmpMaxNode;
    public boolean isValidBST(TreeNode root) {


        if(root==null){
            return  true;
        }
       if(!isValidBST(root.left)) return false;
//        这里会导致一直 return false
        /*
        if(tmpMaxNode!=null&&root.val>tmpMaxNode.val){
            tmpMaxNode=root;
            return isValidBST(root.right);
        }else{
            return  false;
        }

         */

        if(tmpMaxNode!=null&&tmpMaxNode.val>=root.val){
            return false;
        }
        tmpMaxNode=root;
        return  isValidBST(root.right);
    }
}
