package org.bolin.algorithm.Tree.binarySortTreeModifyAndConstruct.L108sortedArrayToBST;

import org.bolin.algorithm.Tree.model.TreeNode;

class L108sortedArrayToBST_250720_1{
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTByIndex(0,nums.length-1,nums);
    }

    private TreeNode sortedArrayToBSTByIndex(int start,int end,int[] nums){
        if(start>end){
            return null;
        }
        int middle=(start+end)/2;
        TreeNode root=new TreeNode(nums[middle]);
        TreeNode leftNode = sortedArrayToBSTByIndex(start, middle - 1,nums);
        TreeNode rightNode = sortedArrayToBSTByIndex(middle + 1, end, nums);
        root.left=leftNode;
        root.right=rightNode;
        return root;



    }
}

public class L108sortedArrayToBST {
}
