package org.save1.DP.Leecode.L53maxSubArray.myself;

public class my1 {


    public int maxSubArray(int[] nums) {
        int [] dp= new int[nums.length];

        int len=nums.length;
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
//            +nums[i] 不能漏掉的啊
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);

        }
        int max=-999999999;
        for(int i=0;i<len;i++){
            max=Math.max(max,dp[i]);
        }
        return  max;


    }




}
