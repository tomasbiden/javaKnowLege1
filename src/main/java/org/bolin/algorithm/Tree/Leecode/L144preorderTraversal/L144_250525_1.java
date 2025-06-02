package org.bolin.algorithm.Tree.Leecode.L144preorderTraversal;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L144_250525_1 {
    List<Integer> path=new ArrayList<>();
    public void traversal(TreeNode root){
        if(root==null){
            return;
        }
        path.add(root.val);
        traversal(root.left);
        traversal(root.right);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return path;
    }

}
