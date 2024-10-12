package org.algorithm.DP.niuke;

import java.util.Arrays;

public class BM70 {

    public static int minMoney (int[] arr, int aim) {
        int []dp=new int[aim+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=aim;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0&&dp[i-arr[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i-arr[j]]+1,dp[i]);
                }

            }
        }

        if(dp[aim]!=Integer.MAX_VALUE){
            return dp[aim];
        }else{
            return -1;
        }
    }
}
