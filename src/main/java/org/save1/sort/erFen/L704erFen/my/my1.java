package org.save1.sort.erFen.L704erFen.my;

public class my1 {
    public int search(int[] nums, int target) {
        return  doubleSearch(nums,0,nums.length-1,target);

    }
    public int doubleSearch(int[] nums,int left,int right,int target){
        if(left>right){
            return  -1;
        }
        int mid=left+(right-left)/2;
        if(nums[mid]==target){
            return  mid;
        }
        if(nums[mid]>target){
            return  doubleSearch(nums,left,mid-1,target);
        }
        if(nums[mid]<target){
            return  doubleSearch(nums,mid+1,right,target);
        }
        return  -1;

    }
    public static int doubleSearch2(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while (left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return  mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return  -1;
    }
}
