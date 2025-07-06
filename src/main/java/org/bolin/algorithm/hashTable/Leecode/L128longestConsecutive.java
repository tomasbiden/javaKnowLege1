package org.bolin.algorithm.hashTable.Leecode;

import java.util.HashSet;
import java.util.Set;

class  L128longestConsecutive_250701_1{
    public int longestConsecutive(int[] nums) {
        Set<Integer>  set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int result=0;
        for (Integer integer : set) {
            if(set.contains(integer-1)){
                continue;
            }
            int tmpNum=integer+1;
            while (set.contains(tmpNum)){
                tmpNum++;
            }
            result=Math.max(result,tmpNum-integer);

        }
        return result;
    }
}
public class L128longestConsecutive {


}
