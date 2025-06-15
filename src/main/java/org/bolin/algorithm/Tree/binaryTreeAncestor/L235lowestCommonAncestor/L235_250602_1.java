package org.bolin.algorithm.Tree.binaryTreeAncestor.L235lowestCommonAncestor;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L235_250602_1 {

    public TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){
        if(root.val>p.val&&root.val>q.val) return traversal(root.left,p,q);
        if(root.val<p.val&&root.val<q.val) return traversal(root.right,p,q);
        return  root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return traversal(root,p,q);
    }
}
