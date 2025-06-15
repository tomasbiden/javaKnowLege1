package org.bolin.algorithm.Tree.binarySortTreeModifyAndConstruct.L108sortedArrayToBST;

import org.bolin.algorithm.Tree.model.TreeNode;

public class L108_250602_1 {
    public TreeNode traversal(int[] nums,int left,int right){
        if(left>=right){
            return  null;
        }
        int mid=(right-1+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=traversal(nums,left,mid);
        root.right=traversal(nums,mid+1,right);
        return  root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
           return traversal(nums,0,nums.length);

    }
}
