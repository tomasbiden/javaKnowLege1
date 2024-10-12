package org.save1.doublePointer.Leecode.threeSum.myself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cp1_1 {
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

    public static void main(String[] args) {
        int[] nums = {-2,-2,-2,0,0,2,2};
        System.out.println(threeSum(nums));


    }
}
