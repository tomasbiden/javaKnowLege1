package org.bolin.algorithm.Array.group1.dir1;

public class L704erFenChaZhao {


//    try1 2025 03 15
    public static int  search(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int middle=(right+left)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else {
                return  middle;
            }
        }
        return  0;
    }
}
