package org.bolin.algorithm.Tree.build.buildLinkedList;

import org.bolin.algorithm.Tree.model.TreeNode;

class  Flatten_250629_1{

    TreeNode head=null;
    public void flatten(TreeNode root) {
        if(root==null){
         return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=head;
        head=root;
    }

}
public class Flatten {
}
