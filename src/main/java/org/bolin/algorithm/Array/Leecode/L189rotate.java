package org.bolin.algorithm.Array.Leecode;

public class L189rotate {

    public void reverse(int[] nums, int start, int end) {
        for(int i=start,j=end;i<j;i++,j--){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }

    }

    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return;
    }
}
