package org.bolin.algorithm.Tree.modifyAndContruct.L226invertTree;

import org.bolin.algorithm.Tree.model.TreeNode;
class L226invertTree_250720_1{
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left=rightNode;
        root.right=leftNode;
        return root;


    }
}














public class L226invertTree {

    public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return  root;
            }

            traversal(root);
            return  root;
    }

    public void traversal(TreeNode root){
        TreeNode left = root.left;
        root.left=root.right;
        root.right=left;

        if(root.left!=null){
            traversal(root.left);
        }
        if(root.right!=null){
            traversal(root.right);
        }
    }
}
