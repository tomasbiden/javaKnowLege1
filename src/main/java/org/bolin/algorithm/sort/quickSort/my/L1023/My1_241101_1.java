package org.bolin.algorithm.sort.quickSort.my.L1023;

public class My1_241101_1 {
//    10分组 5次
    public  void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }

        int priotValue=nums[left];
        int i=left;
        int j=right;
        while (i<j){
//            是i,j不是left，right啊
            while (i<j&&nums[j]>priotValue){
                j--;
            }
//            调换的i,j写反了啊 ，不是i--啊
            if(i<j){
                nums[i++]=nums[j];
            }

            while (i<j&&nums[i]<priotValue){
                i++;
            }
            if(i<j){
                nums[j--]=nums[i];
            }
        }
        nums[i]=priotValue;
//          不是 priotValue-1啊
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);

    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return  nums;

    }
}
