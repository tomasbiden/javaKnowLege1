package org.bolin.algorithm.DP.Leecode.L647countSubstrings.myself;
/*
class Solution {
    public int countSubstrings(String s) {
               char[] chars = s.toCharArray();
        int len=chars.length;
        boolean[][] dp=new boolean[len][len];
        int result=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chars[i]==chars[j]){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    result+=(dp[i][j]==true?1:0);
                }

            }
        }

        return result;

    }
}
 */
public class My1_241026_dp {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][] dp = new boolean[len][len];
//        boolean[][] dp =new int[len][len];
        int result=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        result++;
                        dp[i][j]=true;
                        continue;
                    }

                    if(dp[i+1][j-1]){
                        result++;
                        dp[i][j]=true;
                        continue;
                    }
                }

            }
        }
        return  result;


    }

}
