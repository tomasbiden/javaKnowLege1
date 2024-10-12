package org.algorithm.Tree.Leecode.L102levelOrder.my;

import org.algorithm.Tree.niukehot100.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class my1 {

    public List<List<Integer>> levelOrder(TreeNode root) {


       List<List<Integer>> res = new ArrayList<>();
        if(root==null){
           return res;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            int len=que.size();

            ArrayList<Integer> itemList = new ArrayList<>();
            while (len>0){

                TreeNode tmpNode = que.removeFirst();
                itemList.add(tmpNode.val);
                len--;
                if(tmpNode.left!=null){
                    que.add(tmpNode.left);

                }
                if(tmpNode.right!=null){
                    que.add(tmpNode.right);


                }

            }
            res.add(itemList);


        }


        return res;
    }



    List<List<Integer>> res = new ArrayList<>();
//    递归方法


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root==null){
            return null;
        }
        levelOrderDigui(root,0);
        return res;

    }
    public void levelOrderDigui(TreeNode root,int deep) {
        if(deep>(res.size()-1)){
            res.add(new ArrayList<Integer>());
        }
        res.get(deep).add(root.val);
        if(root.left!=null){
            levelOrderDigui(root.left,deep+1);
        }
        if(root.right!=null){
            levelOrderDigui(root.right,deep+1);
        }


    }



}
