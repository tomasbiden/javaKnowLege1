package org.bolin.algorithm.hashTable.Leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class L349intersection {
    public int[] intersection_250323_1(int[] nums1, int[] nums2) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            integerHashSet.add(nums1[i]);
        }
        HashSet<Integer> resultHashSet = new HashSet<>();
        for(int j=0;j<nums2.length;j++){
            if(integerHashSet.contains(nums2[j])){
                resultHashSet.add(nums2[j]);
            }
        }
        int[] resultArr=new int[resultHashSet.size()];
        int i=0;
        for (Integer value : resultHashSet) {
            resultArr[i++]=value;
        }
        return resultArr;


    }
}
