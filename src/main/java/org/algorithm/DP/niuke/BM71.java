package org.algorithm.DP.niuke;

public class BM71 {

    public int LIS (int[] arr) {
        int len=arr.length;
        int[] dp=new int[len];

        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }

            if(dp[i]==0){
                dp[i]=1;
            }
        }

        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(max,dp[i]);
        }
        return max;



    }
}
