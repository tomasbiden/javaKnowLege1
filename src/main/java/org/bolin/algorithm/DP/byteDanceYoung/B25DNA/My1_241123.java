package org.bolin.algorithm.DP.byteDanceYoung.B25DNA;

public class My1_241123 {
    public static int minDistance(String word1, String word2) {

        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0){
                    dp[i][j]=j;
                    continue;
                }
                if(j==0){
                    dp[i][j]=i;
                    continue;
                }
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];

                }else {
//                    注意是三种情况而不是最长相同子序列那样是2中情况
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[len1][len2];

    }
    public static int solution(String dna1, String dna2) {
       return   minDistance(dna1,dna2);
    }
}
