package org.bolin.algorithm.DP.Leecode.L1143longestCommonSubsequence.myself;

import java.util.Scanner;

public class my1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
//                    注意这里要是 i-1 与 j-1才行的啊
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];

    }
    public static void main(String [] args){

        String text1=new String();
        String text2=new String();



        Scanner sc=new Scanner(System.in);
        /*
        text1=sc.nextLine();
        text2=sc.nextLine();
        System.out.println(text1);
        System.out.println(text2);

         */

        String text=sc.nextLine();
        String[] textArray=text.split(" ");
        text1=textArray[0];
        text2=textArray[1];
        System.out.println(text1);
        System.out.println(text2);


    }
}
