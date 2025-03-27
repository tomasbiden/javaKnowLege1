package org.bolin.algorithm.hashTable.Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// -2 -1 0 0 1 2
public class L18fourSum {

    public List<List<Integer>> fourSum_0326(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int m=0;m<nums.length;m++){
            if(m-1>=0&&nums[m]==nums[m-1]){
                continue;
            }
//            i有范围限制，防止越界
            for(int i=m+1;i<nums.length-2;i++){
//                m>(i-1)
                if(i-1>m&&nums[i]==nums[i-1]){
                    continue;
                }
                int j=i+1; int k=nums.length-1;


//                这里是用while 不是用 if 啊，用if i就没有了啊 ,而且不能分开，而是双指针合并的啊
//                while(j<k&&sum>target){
//                    k--;
//                    continue;
//                }
//                while(j<k&&sum<target){
//                    j++;
//                    continue;
//                }
                while (j<k){
//                    sum 用long
                    long sum=(long)nums[m]+nums[i]+nums[j]+nums[k];
                    if(sum>target){
                        k--;
                    }else if(sum < target){
                        j++;

                    }else{
                        List<Integer> itemList = Arrays.asList(nums[m], nums[i], nums[j], nums[k]);
                        result.add(itemList);
                        while (j<k&&nums[j]==nums[j+1]){
                            j++;
                        }
                        while (j<k&&nums[k]==nums[k-1]){
                            k--;
                        }
                        j++;k--;
                    }

                }


            }
        }
        return  result;
    }
    public static void main(String[] args){
        L18fourSum l18fourSum = new L18fourSum();
        int[] list=new int[]{-2,-1,0,0,1,2};
        l18fourSum.fourSum_0326(list,0);

    }
}
