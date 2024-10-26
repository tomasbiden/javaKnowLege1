package org.bolin.algorithm.DP.Leecode.L5longestPalindrome.myself;
/*
class Solution {
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
}
 */
public class My1_241026_dp {
    public String longestPalindrome(String s) {
        int len=s.length();
        boolean[][] dp = new boolean[len][len];
//        boolean[][] dp =new int[len][len];
        int result=0;
        int ri=0;
        int rj=0;
        int tmpMaxLen=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    int flag=0;
                    if(j-i<=1){

                        dp[i][j]=true;
                        flag=1;

                    }else if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        flag=1;

                    }
//                    放到最外面是错误的啊
                    if(flag==1&&tmpMaxLen<=(j-i+1)){
                        tmpMaxLen=(j-i+1);
                        ri=i;
                        rj=j;
                    }


                }

            }
        }
        String substring = s.substring(ri, rj + 1);

        return  substring;


    }

}
