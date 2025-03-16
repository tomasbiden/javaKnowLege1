package org.bolin.algorithm.Array.group1.dir1;

public class L209minSubArrayLen {

    public int minSubArrayLen_250316_doublePointer_1(int target, int[] nums) {
//        要点，1：先保存最小的长度，再移动，因为我已经保存了，移动后如何小于指定大小也无所谓
//         要点2： 注意要保存特殊不满足的情况

        int i=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while (sum>=target){
//                result=j-i+1;   错误：result 应该是最小值而不是最新值
                result=Math.min(result,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;

    }
}
