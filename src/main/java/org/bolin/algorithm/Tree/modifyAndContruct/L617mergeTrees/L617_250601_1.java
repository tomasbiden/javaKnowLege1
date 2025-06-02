package org.bolin.algorithm.Tree.modifyAndContruct.L617mergeTrees;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L617_250601_1 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if(root1==null) return root2;
         if(root2==null) return  root1;
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left=mergeTrees(root1.left,root2.left);
        treeNode.right=mergeTrees(root1.right,root2.right);
        return treeNode;

    }
}
