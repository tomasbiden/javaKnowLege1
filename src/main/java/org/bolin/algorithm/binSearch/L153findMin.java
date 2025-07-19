package org.bolin.algorithm.binSearch;
class  L153findMin_250706_1{

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
        return nums[left];
    }

}
public class L153findMin {
}
