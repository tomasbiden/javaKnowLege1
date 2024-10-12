package org.save1.codeSuiXiangLu.DP.L5_longestPalindrome;

import java.util.Scanner;

public class first {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len=chars.length;
        boolean[][] dp=new boolean[len][len];
        int result=0;
        int len1=0;
        int in1=0;
        int in2=0;
//        注意这里一定是i--啊
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chars[i]==chars[j]){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    result+=(dp[i][j]==true?1:0);
                    if(dp[i][j]==true&&len1<(j-i+1)){
                        in1=i;
                        in2=j;
                        // 注意这里的要更新长度啊
                        len1=j-i+1;
                    }
                }

            }
        }
        return String.valueOf(chars).substring(in1,in2+1);


    }

    public static void  main(String[] args)  {
        String s= new Scanner(System.in).next();
        char[] chars = s.toCharArray();
        int len=chars.length;
        boolean[][] dp=new boolean[len][len];
        int result=0;
        int len1=0;
        int in1=0;
        int in2=0;
//        注意这里一定是i--啊
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chars[i]==chars[j]){
                    if(j-i<=1){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    result+=(dp[i][j]==true?1:0);
                    if(dp[i][j]==true&&len1<(j-i+1)){
                        in1=i;
                        in2=j;
                        // 注意这里的要更新长度啊
                        len1=j-i+1;
                    }
                }

            }
        }
        System.out.println(String.valueOf(chars).substring(in1,in2+1));


    }
}
