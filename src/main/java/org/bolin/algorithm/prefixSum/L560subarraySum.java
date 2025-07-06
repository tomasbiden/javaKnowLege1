package org.bolin.algorithm.prefixSum;

import java.util.HashMap;
import java.util.Map;

class subarraySum_250702_1{
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumNumMap=new HashMap<>();
//       注意初始化
        sumNumMap.put(0,1);
        int sum=0;
        int reusult=0;
        for(int i=0;i<nums.length;i++){
            reusult+=sumNumMap.getOrDefault(k-nums[i],0);
           sum+=nums[i];
           sumNumMap.merge(sum,1,Integer::sum);
        }
        return reusult;


    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer,Integer> sumNumMap=new HashMap<>();
//       注意初始化
        sumNumMap.put(0,1);
        int sum=0;
        int reusult=0;
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           reusult+=sumNumMap.getOrDefault(sum-k,0);
           sumNumMap.merge(sum,1,Integer::sum);
        }
        return reusult;


    }
    public static void main(String[] args){

    }
}
public class L560subarraySum {


}
