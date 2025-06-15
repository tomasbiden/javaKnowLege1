package org.bolin.algorithm.Tree.binaryTreeAncestor.L236lowestCommonAncestor;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L236_250602_1 {

    public TreeNode traversal(TreeNode root ,TreeNode p,TreeNode q){
        if(root==null||root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode leftTra = traversal(root.left, p, q);
        TreeNode rightTra = traversal(root.right, p, q);
        if(leftTra==null&&rightTra!=null) return rightTra;
        if(leftTra!=null&&rightTra==null) return  leftTra;
        if(leftTra!=null&&rightTra!=null) return root;
        return null;


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);
    }
}
