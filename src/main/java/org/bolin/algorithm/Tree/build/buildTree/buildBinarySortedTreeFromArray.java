package org.bolin.algorithm.Tree.build.buildTree;

import org.bolin.algorithm.Tree.model.TreeNode;

class D20250628_1{


    public TreeNode buildNode(int[] nums,int left,int right) {
        if(left>=right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(nums[(left+right)/2]);
        node.left=buildNode(nums,left,mid);
        node.right=buildNode(nums,mid+1,right);
        return node;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums,0,nums.length);
    }

    public static void main(String[] args){
        D20250628_1 d202506281 = new D20250628_1();
        TreeNode treeNode = d202506281.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});


    }


}
public class buildBinarySortedTreeFromArray {


}
