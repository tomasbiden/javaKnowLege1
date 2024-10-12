package org.algorithm.DP.niuke;

public class BM3 {

    public int minCostClimbingStairs (int[] cost) {
        int len=cost.length;
        if(len==0||len==1){
            return 0;
        }
        int tmp=0;
        int di2=0;
        int di1=0;
        for(int i=2;i<=len;i++){
            if(cost[i-1]+di1>cost[i-2]+di2){
                tmp=cost[i-2]+di2;
            }else{
                di1=cost[i-1]+di1;
            }
            di2=di1;
            di1=tmp;

        }
        return  tmp;
    }
}
