package org.bolin.algorithm.Array.group1.dir1;

public class L27removeElement {

//    2025 03 16

    public int removeElement_250316(int[] nums, int val) {
        int slow=-1;
        int fast=0;
        for(int i=fast;i<nums.length;i++){
            if(nums[i]!=val){
                nums[++slow]=nums[i];
            }
        }
        return  slow+1;

    }
}
