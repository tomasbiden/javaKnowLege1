package org.bolin.algorithm.sort.quickSort.my.L1023;

import java.util.Random;

public class My1_241122 {
    public static int partition(int[] nums,int left, int right){

        int l=left;
        int r=right;
        Random random = new Random();
//  [0-bound-1]
        int distance = random.nextInt(right-left+1);
        int randomIndex=left+distance;

//  咋一个swap你都写错了啊
        int tmp=nums[randomIndex];
        nums[randomIndex]=nums[left];
        nums[left]=tmp;



        int priotValue=nums[left];
        while (l<r){
            while (l<r&&nums[r]>priotValue){
                r--;

            }
            if(l<r){
                nums[l++]=nums[r];
            }
            while (l<r&&nums[l]<priotValue){
                l++;
            }
            if(l<r){
                nums[r--]=nums[l];
            }

        }
//        最后一步不能漏掉了啊
         nums[l]=priotValue;
        return l;
    }
    public  static void quickSort(int[] nums,int left,int right){
        if(right<=left){
            return;
        }
        int priot=partition(nums,left,right);
        quickSort(nums,left,priot-1);
        quickSort(nums,priot+1,right);


    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return  nums;

    }
    public static void main(String[] args){
        int[] array=new int[]{1,4,-1,34,-9,-3};
//        partition(array,0,array.length-1);
//        注意是一定要-1的啊
        quickSort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+" ");

        }
    }

}
