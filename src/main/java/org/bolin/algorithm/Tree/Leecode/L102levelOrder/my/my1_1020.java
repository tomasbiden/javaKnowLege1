package org.bolin.algorithm.Tree.Leecode.L102levelOrder.my;

import java.util.ArrayList;
import java.util.List;

public class my1_1020 {
    public static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(){

        }
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<TreeNode> treeNodes1 = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        if(root==null){
            return  res;
        }

        treeNodes1.add(root);
//        !=null 错误的啊

        while (treeNodes1.size()>0){
            ArrayList<Integer> tmpList = new ArrayList<>();

            ArrayList<TreeNode> sonNodes = new ArrayList<TreeNode>();
            int size=treeNodes1.size();
            int i=0;
            while (i<size){

                TreeNode treeNode = treeNodes1.get(i);

                System.out.println(treeNodes1.size()+" "+ treeNode.val);
//                treeNodes1.remove(0);
                if(treeNode.left!=null){
                    sonNodes.add(treeNode.left);
                }

                if(treeNode.right!=null){
                    sonNodes.add(treeNode.right);
                }

                tmpList.add(treeNode.val);
                i++;



            }
            treeNodes1=sonNodes;
            res.add(tmpList);



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
