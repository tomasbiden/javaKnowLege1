package org.save1.codeSuiXiangLu.List;

import java.util.Scanner;

public class first {
    public int countSubstrings_e1(String s) {
        char[] chars = s.toCharArray();
        int len=chars.length;
        boolean[][] dp=new boolean[len][len];
        int result=0;
        for(int i=len-1;i>=0;i++){
            for(int j=i;j<len;j++){
//                if 这里就错误了， 应先判断是否相等
                if(j-i<=1){
                    dp[i][j]=true;

                } else if (chars[i]==chars[j]) {
                    dp[i][j]=dp[i+1][j-1];

                }else {
                    dp[i][j]=false;
                }

                result+=(dp[i][j]==true?1:0);
            }
        }

        return result;



    }

    public static  int countSubstrings(String s) {

        char[] chars = s.toCharArray();

//        String string = String.valueOf(chars);
//        System.out.println(string);

//        System.out.println(string);
        int len=chars.length;
        boolean[][] dp=new boolean[len][len];
        int result=0;
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
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int result=countSubstrings(s);
        System.out.println(result);





    }
}
