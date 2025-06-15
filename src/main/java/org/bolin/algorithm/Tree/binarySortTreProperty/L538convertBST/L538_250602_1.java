package org.bolin.algorithm.Tree.binarySortTreProperty.L538convertBST;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L538_250602_1 {

    int preValue=0;
    public void traversal(TreeNode root){
        if(root==null){
            return;
        }
        traversal(root.right);
        preValue+=root.val;
        root.val=preValue;
        traversal(root.left);

    }

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
}
