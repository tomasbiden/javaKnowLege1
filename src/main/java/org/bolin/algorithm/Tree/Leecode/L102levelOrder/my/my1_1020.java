package org.bolin.algorithm.Tree.Leecode.L102levelOrder.my;

import org.bolin.algorithm.Tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class my1_1020 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<TreeNode> tmpQueue = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        if(root==null){
            return  res;
        }

        tmpQueue.add(root);
//        !=null 错误的啊

        while (tmpQueue.size()>0){
            ArrayList<Integer> tmpValueList = new ArrayList<>();

            ArrayList<TreeNode> sonNodes = new ArrayList<TreeNode>();
            int size=tmpQueue.size();
            int i=0;
            while (i<size){

                TreeNode treeNode = tmpQueue.get(i);

                System.out.println(tmpQueue.size()+" "+ treeNode.val);
//                tmpQueue.remove(0);
                if(treeNode.left!=null){
                    sonNodes.add(treeNode.left);
                }

                if(treeNode.right!=null){
                    sonNodes.add(treeNode.right);
                }

                tmpValueList.add(treeNode.val);
                i++;



            }
            tmpQueue=sonNodes;
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

        my1_1020 my11020 = new my1_1020();
        my11020.levelOrder(treeNode1);



    }

}
