package org.bolin.algorithm.Array.Leecode.L1twoSum;

import java.util.HashMap;

public class my1 {
    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();

        int[] res=new int[2];
        int x=0;
        int y=0;

        int len=nums.length;
        for(int i=0;i<len;i++){
            hashMap1.put(nums[i],i);
        }

        for(int i=0;i<len;i++){
            Integer i1 = hashMap1.get(target - nums[i]);
            if(i1!=null&&i1!=i){
                res[0]=i;
                res[1]=i1;

            }


        }
        return  res;





    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();

        int[] res=new int[2];
        int x=0;
        int y=0;

        int len=nums.length;

        for(int i=0;i<len;i++){
            Integer i1 = hashMap1.get(target - nums[i]);
            if(i1!=null){
                res[0]=i;
                res[1]=i1;
                return  res;
            }
            hashMap1.put(nums[i],i);


        }
        return  null;






    }
}
