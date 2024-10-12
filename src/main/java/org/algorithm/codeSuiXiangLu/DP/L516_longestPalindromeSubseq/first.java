package org.algorithm.codeSuiXiangLu.DP.L516_longestPalindromeSubseq;

public class first {


    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        char[] chars = s.toCharArray();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(chars[i]==chars[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return  dp[0][len-1];
    }
}
