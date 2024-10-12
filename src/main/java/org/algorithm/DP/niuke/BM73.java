package org.algorithm.DP.niuke;

public class BM73 {

    public static int getLongestPalindrome (String A) {
        // write code here

        int len=A.length();
        int [] dp=new int[len];
        int i=0; int j=len-1;
        while(i<=j){

            if(A.charAt(i)==A.charAt(j)){
                if(i==0){
                    dp[i]=1;
                    i++;
                    j--;
                    continue;
                }

                if(dp[i-1]>0){
                    dp[i]=dp[i-1]+1;

                }else{
                    dp[i]=1;
                }

                i++;
                j--;

            }
            i++;
            j--;

        }

        int max=0;
        for( i=0;i<len;i++){
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
