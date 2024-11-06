package org.bolin.algorithm.DP.Leecode.L322coinChange.myself;

import java.util.Arrays;

public class My1_241106_1 {
    public int coinChange(int[] coins, int amount) {

        int []dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            //  array .length没有 ()
            for(int j=0;j<coins.length;j++){

                // 注意越界问题啊
                if(i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    // System.out.println(i+" "+dp[i]);
                }
            }
        }

        if(dp[amount]==amount+1){
            return -1;
        }else{
            return dp[amount];
        }

    }
}
