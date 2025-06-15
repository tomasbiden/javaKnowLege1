package org.bolin.algorithm.Tree.binarySortTreeModifyAndConstruct.L450deleteNode;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L450_1_250602_1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key>root.val)root.right=deleteNode(root.right,key);
        if(key< root.val)root.left=deleteNode(root.left,key);
        if(root.val==key){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode rootRight = root.right;
            TreeNode cur=rootRight;
            while (cur.left!=null){
                cur=cur.left;
            }
            cur.left=root.left;
            return root.right;

        }
        return root;
    }
}
