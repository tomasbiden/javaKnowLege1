package org.algorithm.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

public class my2 {


    public int lengthOfLIS(int[] nums) {
        int maxValue=80000+10;

        int len=nums.length;
        int[] dp=new int[len];
        int maxRes=0;
        Arrays.fill(dp,1);

        for(int i=0;i<len;i++){

        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        maxRes=Math.max(maxRes,dp[i]);


        }
        return  maxRes;





    }
}
