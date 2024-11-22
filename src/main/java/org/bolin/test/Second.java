package org.bolin.test;

import java.util.HashMap;

public class Second {
    public static  int findSameNumber(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                return  nums[i];
            }else {
                hashMap.put(nums[i],i);
            }
        }
//        异常情况
        return -1;

    }
    public static void main(String[] args){
        int[] nums=new int[]{5,6,4,6};
        int sameNumber = findSameNumber(nums);
        System.out.println(sameNumber);


    }
}
