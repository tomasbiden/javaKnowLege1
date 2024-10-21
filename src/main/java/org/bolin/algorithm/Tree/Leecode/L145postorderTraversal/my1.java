package org.bolin.algorithm.Tree.Leecode.L145postorderTraversal;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class my1 {
    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return  list;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;



    }
}
