package org.algorithm.Tree.Leecode.L94;

import org.algorithm.Tree.niukehot100.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L94inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal2(root,list);
        return list;
    }
    public void inorderTraversal2(TreeNode root,List<Integer> list) {

        if(root==null){
            return ;
        }
        inorderTraversal2(root.left,list);
        list.add(root.val);
        inorderTraversal2(root.right,list);
        return  ;


    }



}
