package org.bolin.algorithm.DP.Leecode.L152maxProduct;

class  L152maxProduct_250709_1{
//
    public int maxProduct_repeate_caculate(int[] nums) {
        int maxResult=Integer.MIN_VALUE;
        int preMax=nums[0];
        int preMin=nums[0];
        maxResult=Math.max(maxResult,preMax);
        for(int i=1;i<nums.length;i++){
            preMax=Math.max(Math.max(preMin*nums[i],preMax*nums[i]),nums[i]);
            preMin=Math.min(Math.min(preMax*nums[i],preMin*nums[i]),nums[i]);
            maxResult=Math.max(maxResult,preMax);
        }
        return maxResult;

    }

    public int maxProduct(int[] nums) {
        int maxResult=Integer.MIN_VALUE;
//       初始值默认赋值为1就可以轻松很多
        int preMax=1;
        int preMin=1;
        for(int i=0;i<nums.length;i++){
            int curMax=Math.max(Math.max(preMin*nums[i],preMax*nums[i]),nums[i]);
            int curMin=Math.min(Math.min(preMax*nums[i],preMin*nums[i]),nums[i]);
            preMax=curMax;
            preMin=curMin;
            maxResult=Math.max(maxResult,curMax);
        }
        return maxResult;

    }
    public static void main(String[] args){
        int[] nums=new int[]{-4,-3,-2};
        L152maxProduct_250709_1 l152maxProduct2507091 = new L152maxProduct_250709_1();
        l152maxProduct2507091.maxProduct(nums);

    }
}
public class L152maxProduct {
}
