package org.bolin.algorithm.Tree.Leecode.L102levelOrder.my;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class My1_241102_1 {
//    6分钟 2次
    List<List<Integer>> res=new ArrayList<>();
    public void levelOrderByheight(TreeNode root,int height) {
        if(root==null){
            return;
        }
        if(res.size()<(height+1)){
            List<Integer> newList=new ArrayList<>();
            res.add(newList);

        }
        res.get(height).add(root.val);
        if(root.left!=null){
            levelOrderByheight(root.left,height+1);
        }
        if(root.right!=null){
            levelOrderByheight(root.right,height+1);
        }


    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderByheight(root,0);
        return  res;


    }
}
