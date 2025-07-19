package org.bolin.algorithm.DP.Leecode.L416canPartition;

import java.util.Arrays;

class L416canPartition_250716_1{
    public boolean canPartition(int[] nums) {
//      4：相加其值可能很大
        int[][] memory=new int[nums.length][201];
        for(int i=0;i<memory.length;i++){
            Arrays.fill(memory[i],-1);
        }
        boolean dfs = dfs(nums, nums.length - 1, 0, memory);
        return dfs;
    }

    private boolean dfs(int[] nums,int n,int value,int[][] memory){
//       2:处理错误
//        if(n<0&&value==0){
//            return true;
//        }
//      3:注意临界条件判断了啊
        if(n<0||value<0){
            return false;
        }
        if(memory[n][value]!=-1){
            return memory[n][value]==1;
        }
//        n 错误
        int cha=Math.abs(nums[n]-value);
        boolean dfs = dfs(nums, n - 1, cha, memory);
        boolean dfs1 = dfs(nums, n - 1, nums[n] + value, memory);


        memory[n][value]=(dfs(nums,n-1,cha,memory)==true||dfs(nums,n-1,nums[n]+value,memory)==true?1:0);
         return memory[n][value]==1;
    }
    public static void main(String [] args){
        L416canPartition_250716_1 l416canPartition2507161 = new L416canPartition_250716_1();
        l416canPartition2507161.canPartition(new int[]{1,5,11,5});

    }
}
public class L416canPartition {



}
