package org.algorithm.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

public class my1 {


    public int lengthOfLIS(int[] nums) {
        int maxValue=80000+10;
        int[] dp=new int[maxValue];
        int len=nums.length;
        int maxRes=0;
        Arrays.fill(dp,0);

        for(int i=0;i<len;i++){
            nums[i]+=40001;

//            注意是dp[nums[i]] ，而不是dp[i], 这里注意一定要等于，要不然会把0给漏掉了啊，完了等于也是不行的啊
            for(int j=0;j<nums[i];j++){
                dp[nums[i]]= Math.max(dp[nums[i]],dp[j]+1);
            }
//            最小为1，防止0的情况下没有进行考虑
            dp[nums[i]]=Math.max(dp[nums[i]],1);
            maxRes=Math.max(maxRes,dp[nums[i]]);


        }
        return  maxRes;





    }
}
