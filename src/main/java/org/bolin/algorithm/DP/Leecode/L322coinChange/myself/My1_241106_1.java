package org.bolin.algorithm.DP.Leecode.L322coinChange.myself;

import java.util.Arrays;
class L322_2507015_1{
    public int coinChange(int[] coins, int amount) {
        int[] memory = new int[amount + 1];
        Arrays.fill(memory,-2);

        return dfs(coins,amount,memory);
    }
    public int dfs(int[] coins,int amount,int[] memory){
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(memory[amount]!=-2){
            return memory[amount];
        }
        int minCnt=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(dfs(coins,amount-coins[i],memory)!=-1){
                minCnt=Math.min(minCnt,dfs(coins,amount-coins[i],memory)+1);
            }
        }
        memory[amount]=(minCnt==Integer.MAX_VALUE?-1:minCnt);
        return memory[amount];

    }
    public static void main(String[] args){
        L322_2507015_1 l32225070151 = new L322_2507015_1();
        l32225070151.coinChange(new int[]{1,2,5},11);

    }
}
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
