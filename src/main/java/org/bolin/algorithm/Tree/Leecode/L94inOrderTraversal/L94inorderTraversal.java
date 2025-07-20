package org.bolin.algorithm.Tree.Leecode.L94inOrderTraversal;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

class L94inorderTraversal_250720_1{

    List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return null;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;

    }
}
public class L94inorderTraversal {
}
