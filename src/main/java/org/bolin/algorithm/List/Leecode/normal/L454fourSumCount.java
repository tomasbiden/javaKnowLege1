package org.bolin.algorithm.List.Leecode.normal;

import java.util.HashMap;

public class L454fourSumCount {
    public int fourSumCount_250324(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j< nums2.length;j++){
                int sum1=nums1[i]+nums2[j];
                if(hashMap1.containsKey(sum1)){
                    hashMap1.replace(sum1,hashMap1.get(sum1)+1);
                }else {
                    hashMap1.put(sum1,1);
                }
            }
        }
        int result=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j< nums4.length;j++){
                int sum1=nums3[i]+nums4[j];
                if(hashMap1.containsKey(sum1*(-1))){
                    result+=hashMap1.get(sum1);
                }
            }
        }
        return  result;
    }
}
