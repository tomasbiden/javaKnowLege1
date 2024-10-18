package org.bolin.algorithm.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

public class my2_10_16_2 {
    public static int bin_search(int [] tan,int tmpMaxLen,int value){
        int l=0; int r= tmpMaxLen;
        while(l<r){
            int mid=(r+l+1)/2;
            if(tan[mid]>=value){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        return l;
    }


    public static int lengthOfLIS(int[] nums) {

        int len=nums.length;
        if(len==0){
            return 0;
        }
        int[] tan=new int[len+1];
        Arrays.fill(tan,0);
        int tmpMaxLen=0;
        tan[0]=Integer.MIN_VALUE;

//        i从1开始了啊
        for(int i=0;i<len;i++){

            if(nums[i]>tan[tmpMaxLen]){

                tan[++tmpMaxLen]=nums[i];
            }else{
                int position=bin_search(tan,tmpMaxLen,nums[i]);
                tan[position+1]=nums[i];

            }
//            System.out.println(i+" "+ tan[tmpMaxLen]);


        }

        return tmpMaxLen;


    }
    public static void main(String[] args){
        int[] nums=new int[10];
        System.out.println(Arrays.toString(nums));
        System.out.println(lengthOfLIS(nums));
        double x=50.1234567e5;
        System.out.println(x);
    }
}
