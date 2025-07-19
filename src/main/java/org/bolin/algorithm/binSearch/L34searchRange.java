package org.bolin.algorithm.binSearch;

class  L34searchRange_250706_1{
    public int[] searchRange(int[] nums, int target) {
        int leftResult = binSearch(nums, target);
        if(leftResult==nums.length||nums[leftResult]>target){
            return new int[]{-1,-1};
        }
        int rightResult=binSearch(nums,target+1)-1;
        return new int[]{leftResult,rightResult};

    }

    private int binSearch(int[] nums,int target){
        int left=0;
        int right=nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}
public class L34searchRange {
}
