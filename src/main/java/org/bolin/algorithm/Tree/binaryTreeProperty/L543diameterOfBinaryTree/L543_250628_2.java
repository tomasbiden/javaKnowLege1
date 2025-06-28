
package org.bolin.algorithm.Tree.binaryTreeProperty.L543diameterOfBinaryTree;

import org.bolin.algorithm.Tree.buildTree.BuildTree;
import org.bolin.algorithm.Tree.model.TreeNode;

public class L543_250628_2
{
    int result=0;
    public int  getHeight(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        int leftHeight=getHeight(treeNode.left);
        int rightHeight=getHeight(treeNode.right);
        result=Math.max(result,Math.max(leftHeight,rightHeight));
        return  Math.max(leftHeight,rightHeight)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        getHeight(root);
        return result;

    }
    public static void main(String[] args){
        L543_250628_2 l5432506282 = new L543_250628_2();
        int[] array=new int[]{1,2,3,4,5};
        TreeNode treeNode = BuildTree.buildBinaryTreeFromArray(0,array);
        l5432506282.diameterOfBinaryTree(treeNode);
        System.out.println(l5432506282.result);

    }
}
