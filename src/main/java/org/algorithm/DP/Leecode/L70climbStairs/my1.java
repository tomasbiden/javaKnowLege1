package org.algorithm.DP.Leecode.L70climbStairs;

public class my1 {
    public int climbStairs(int n) {
        long x=0;

        long a=1; long b=2;
        if(n==1||n==2){
            return n==1?1:2;
        }
        for(int i=3;i<=n;i++){
            x=(a+b);
            a=b;
            b=x;
        }
        return  (int)x;
    }
}
