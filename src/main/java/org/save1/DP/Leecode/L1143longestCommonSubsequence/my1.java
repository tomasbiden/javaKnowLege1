package org.save1.DP.Leecode.L1143longestCommonSubsequence;

public class my1 {
    public int longestCommonSubsequence_error(String text1, String text2) {
        int len=0;
        for(int i=0;i<text1.length();i++){
            if(text1.charAt(i)==text2.charAt(len)){
                len++;
            }
        }
        return  len;



    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] dp=new  int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];




    }
}
