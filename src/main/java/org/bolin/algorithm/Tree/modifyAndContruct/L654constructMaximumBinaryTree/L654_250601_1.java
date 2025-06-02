package org.bolin.algorithm.Tree.modifyAndContruct.L654constructMaximumBinaryTree;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L654_250601_1 {
    public TreeNode buildTree(int[] nums,int leftIndex,int rightIndex){
        if(leftIndex>=rightIndex){
            return  null;
        }
        int maxIndex=0;
        int maxValue=Integer.MIN_VALUE;
        for(int i=leftIndex;i<rightIndex;i++){
            if(maxValue<nums[i]){
                maxValue=nums[i];
                maxIndex=i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left=buildTree(nums,leftIndex,maxIndex);
        root.right=buildTree(nums,maxIndex+1,rightIndex);
        return root;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums,0,nums.length);
    }
}
