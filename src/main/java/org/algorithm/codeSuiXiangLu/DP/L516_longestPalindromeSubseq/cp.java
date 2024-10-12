package org.algorithm.codeSuiXiangLu.DP.L516_longestPalindromeSubseq;

import java.util.Scanner;

public class cp {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];

    }
    public static void main(String[] args){
        String s=new Scanner(System.in).next();
        System.out.println(longestPalindromeSubseq(s));
    }

}
