package org.bolin.algorithm.Tree.binarySortTree.L700searchBST;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L700_1 {

    public TreeNode searchBST(TreeNode root, int val) {
//        注意空异常
        if(root==null) return null;
        if(val<root.val) return  searchBST(root.left,val);
        if(val>root.val) return searchBST(root.right,val);
        return  root;
    }
}
