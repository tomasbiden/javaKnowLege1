package org.bolin.algorithm.hashTable.Leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class L1twoSum {
    public int[] twoSum_250323_1(int[] nums, int target) {
        Map<Integer,Integer> valueIndexMap = new HashMap<>();
        int count=0;
        int aIndex=-1;
        int bIndex=-1;
        for(int i=0;i<nums.length;i++){

            valueIndexMap.put(nums[i],i);
            if(target%2==0&&nums[i]==target/2){
                count++;
                if(count==1){
                    aIndex=i;
                }else {
                    bIndex=i;
                }
            }
        }
        if(count==2){
            return  new int[]{aIndex,bIndex};
        }
        for(int i=0;i<nums.length;i++){
//      nums[i]*2!=target 非常重要的啊
           if(nums[i]*2!=target&&valueIndexMap.containsKey(target-nums[i])){
               aIndex=valueIndexMap.get(target-nums[i]);
               bIndex=i;
               return  new int[]{aIndex,bIndex};
           }
        }
        return null;
    }
    public int[] twoSum_250323_2(int[] nums, int target) {
        Map<Integer,Integer> valueIndexMap = new HashMap<>();
        int count=0;
        int aIndex=-1;
        int bIndex=-1;
        for(int i=0;i<nums.length;i++){
            if(valueIndexMap.containsKey(target-nums[i])){
                return new int[]{i,valueIndexMap.get(target-nums[i])};
            }else{
                valueIndexMap.put(nums[i],i);
            }
        }
        return null;
    }
}
