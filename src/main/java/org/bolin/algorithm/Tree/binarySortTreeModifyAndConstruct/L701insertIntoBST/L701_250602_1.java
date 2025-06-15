package org.bolin.algorithm.Tree.binarySortTreeModifyAndConstruct.L701insertIntoBST;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L701_250602_1 {


    public TreeNode insertIntoBST(TreeNode root, int val) {
//        注意右 root.left root.right
        if(root==null) return new TreeNode(val);
        if(root.val>val)  root.left= insertIntoBST(root.left,val);
        if(root.val<val)  root.right=  insertIntoBST(root.right,val);
        return root;
    }
}
