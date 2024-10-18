package org.bolin.algorithm.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

public class my2_10_16 {
    public static int bin_search(int [] tan,int tmpMaxLen,int value){
        int l=1; int r= tmpMaxLen;
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
        int tmpMaxLen=1;
        tan[1]=nums[0];

//        i从1开始了啊
        for(int i=1;i<len;i++){

            if(nums[i]>tan[tmpMaxLen]){

                tan[++tmpMaxLen]=nums[i];
            }else{
                int position=bin_search(tan,tmpMaxLen,nums[i]);
//                注意这个处理啊,这个&&也特别重要，position为1可能更新 tan1 ，也可能更新tan2,注意是tan1 而不是tan0啊，最短1啊，注意这里是大于等于才行啊
                if(position==1&&tan[1]>=nums[i]){
                    tan[position]=nums[i];
                }else{
                    tan[position+1]=nums[i];
                }


            }
            System.out.println(i+" "+ tan[tmpMaxLen]);


        }

        return tmpMaxLen;


    }
    public static void main(String[] args){
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
