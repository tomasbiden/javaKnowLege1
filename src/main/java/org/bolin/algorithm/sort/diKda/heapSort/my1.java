package org.bolin.algorithm.sort.diKda.heapSort;

import java.util.Arrays;

public class my1 {
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void adjustHeam(int[] nums,int index,int length) {
//        这个len长度一定要放到函数值，因为后续堆排序时未排序的nums的大小事不断变化的啊
        if((index*2+1)>=length){
            return;
        }
//       int maxIndex=(index*2+2)>=index?index*2+1:Math.max(nums[index*2+1],nums[index*2+2]); 这里有问题的啊
//        (index*2+2)>=length?index*2+1:Math.max(nums[index*2+1],nums[index*2+2]); 这里还是有问题的啊
        int maxIndex=(index*2+2)>=length?index*2+1:(nums[index*2+2]>nums[index*2+1]?index*2+2:index*2+1);
        if(nums[index]<nums[maxIndex]){
            swap(nums,index,maxIndex);
            adjustHeam(nums,maxIndex,length);
        }





    }
    public   int findKthLargest(int[] nums,int k){
        int len=nums.length;
//        (len-1/2) 这个括号是错误的啊
        for(int i=((len-1)/2);i>=0;i--){
            adjustHeam(nums,i,len);
        }

//        System.out.println("最大堆化后" + Arrays.toString(nums));
        for(int i=len-1;i>=(len-k);i--){
//            将大顶放到最后面
            swap(nums,i,0);
//            长度 -1
            adjustHeam(nums,0,i);
        }
//        nums[len-1]是第1大， nums[len-k] 就是第k大
        return nums[len-k];



    }
}
