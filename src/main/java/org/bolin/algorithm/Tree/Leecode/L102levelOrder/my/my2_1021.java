package org.bolin.algorithm.Tree.Leecode.L102levelOrder.my;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class my2_1021 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {


            int depth=-1;
            levenOrderBaseOnDepth(root,++depth);
            return  null;
    }

    public  void levenOrderBaseOnDepth(TreeNode  root, int depth){
        if(root==null){
            return;
        }
        if(res.size()<(depth+1)){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        levenOrderBaseOnDepth(root.left,depth+1);
        levenOrderBaseOnDepth(root.right,depth+1);


    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(99);

        System.out.println(treeNode.left);
    }
}
