package org.bolin.algorithm.Tree.build.buildTree;

import org.bolin.algorithm.Tree.model.TreeNode;

public class BuildTree {

    public static TreeNode buildBinaryTreeFromArray(int tmpIndex,int[] array){
        if(tmpIndex>=array.length||array[tmpIndex]==-1){
            return null;
        }
        TreeNode left=buildBinaryTreeFromArray(tmpIndex*2+1,array);
        TreeNode right=buildBinaryTreeFromArray(tmpIndex*2+2,array);
        TreeNode treeNode = new TreeNode(array[tmpIndex]);

        treeNode.left=left;
        treeNode.right=right;
        return  treeNode;

    }
}
