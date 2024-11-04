package org.bolin.algorithm.sort.heapSort.myself;

public class My1_241102_1 {
//    10分组
    public void adjustHeap(int[] nums,int index,int len){
        if(index*2+1>=len){
            return;
        }

        int lValue=(index*2+1)<len?nums[index*2+1]:Integer.MIN_VALUE;
//        +2不是+1
        int rValue=(index*2+2)<len?nums[index*2+2]:Integer.MIN_VALUE;
        int mChild=lValue>=rValue?(index*2+1):(index*2+2);
        int mValue=nums[mChild];
        if(nums[index]<mValue){
            int tmp=nums[index];
            nums[index]=mValue;
            nums[mChild]=tmp;
            adjustHeap(nums,mChild,len);

        }
    }

    public int[] sortArray(int[] nums) {
        int len=nums.length;
//
        for(int i=(len/2);i>=0;i--){
            adjustHeap(nums,i,len);
        }
        for(int i=len-1;i>=0;i--){
            int tmp=nums[0];
            nums[0]=nums[i];
            nums[i]=tmp;
            adjustHeap(nums,0,i);

        }
        return  nums;

    }
}
