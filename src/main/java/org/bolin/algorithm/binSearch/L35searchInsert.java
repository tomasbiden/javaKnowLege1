package org.bolin.algorithm.binSearch;

class L35searchInsert_250706_1{
//    左闭有开，右边优先
    public int searchInsert(int[] nums, int target) {
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
public class L35searchInsert {
}
