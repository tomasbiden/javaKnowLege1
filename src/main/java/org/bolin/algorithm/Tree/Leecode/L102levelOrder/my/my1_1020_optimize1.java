package org.bolin.algorithm.Tree.Leecode.L102levelOrder.my;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class my1_1020_optimize1 {

    public List<List<Integer>> levelOrder(TreeNode root) {



        List<List<Integer>> res = new ArrayList<>();

        if(root==null){
            return  res;
        }

        LinkedList<TreeNode> tmpQueue = new LinkedList<>();

        tmpQueue.add(root);
//        !=null 错误的啊
//          queue,不能用 ArrayList 而是应该用 LinkedList啊
        while (tmpQueue.size()>0){
            ArrayList<Integer> tmpValueList = new ArrayList<>();
            int size=tmpQueue.size();

            while (size>0){

                TreeNode head = tmpQueue.poll();


//                tmpQueue.remove(0);
                if(head.left!=null){
                    tmpQueue.add(head.left);
                }

                if(head.right!=null){
                    tmpQueue.add(head.right);
                }

                tmpValueList.add(head.val);
                size--;



            }

            res.add(tmpValueList);



        }
        return  res;


    }
    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;

        my1_1020_optimize1 my11020 = new my1_1020_optimize1();
        my11020.levelOrder(treeNode1);



    }

}
