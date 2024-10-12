package org.algorithm.DP.ziJie.z416FenGeDengHeZiJi;

import java.util.Arrays;

public class first {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int[] dp=new int[20000+1];
        Arrays.fill(dp,-1);
        dp[0]=1;

//         这个代码有 一件商品多次使用的问题
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            for(int j=0;j<=sum;j++){
                if(dp[j]==1){
                    dp[j+nums[i]]=1;
                }
            }

        }
//        注意一定为偶数才可以
        if(dp[sum/2]==1&&sum%2==0){
            return  true;
        }else {
            return  false;
        }


    }
}
