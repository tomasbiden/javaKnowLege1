package org.bolin.algorithm.binSearch;
class L33search_250706_1{
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[nums.length-1]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
    public int searchInsert(int[] nums,int left,int right, int target) {
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
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int searInsertResult;
        if(target>nums[nums.length-1]){
            searInsertResult=searchInsert(nums,0,minIndex,target);
        }else {
            searInsertResult=searchInsert(nums,minIndex,nums.length,target);
        }
        return nums[searInsertResult]==target?searInsertResult:-1;

    }
}
public class L33search {
}
