package org.bolin.algorithm.doublePointer.Leecode.L15threeSum.myself;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 31- 45     3
/*
class Solution {
         public static List<List<Integer>> threeSum(int[] nums) {
//        注意不要漏掉先排序啊
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (len - 2); i++) {
//            不要漏掉先前去重啊, 注意i>0的数组越界问题
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
//            注意j=i+1
            int j = i + 1;
            int r = len - 1;

            while (j < r) {
//                    sum放到while里面
                int sum = nums[i] + nums[j] + nums[r];
                if (sum > 0) {
                    r--;
                    continue;
                }

                if (sum < 0) {
                    j++;
                    continue;
                }
                if (sum == 0) {
                    while (j < r && nums[j] == nums[j + 1]) j++;
                    while (j < r && nums[r] == nums[r - 1]) r--;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[r]);
                    res.add(list);
                    j++;
                    r--;

                }
            }

        }
        return res;

    }
}
 */
public class My1_241101_1 {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>>  res= new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
//            注意是 i-1>=0  , 这 里也需要 i<len啊
            while (i-1>=0&&i<len&&nums[i]==nums[i-1]) i++;

            int left=i+1;
            int right=len-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    List<Integer> tmpList  = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    res.add(tmpList);
//                left<right不能漏掉了啊,注意不要越界啊
                    while (left<right&&nums[left]==nums[left+1])left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;

                    left++;
                    right--;



                }
            }
        }
        return  res;

    }
}
