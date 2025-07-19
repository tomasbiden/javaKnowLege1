package org.bolin.algorithm.DP.Leecode.L300lengthOfLIS.myself;

import java.util.Arrays;

class L300lengthOfLIS_250715_1 {
    public int lengthOfLIS(int[] nums) {
        int[] memory = new int[nums.length];
        Arrays.fill(memory, -1);
//       必须每个遍历，否则会有较大值漏掉情况啊
        for (int i = nums.length - 1; i >= 0; i--) {
            dfs(nums, i, memory);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < memory.length; i++) {
            result = Math.max(result, memory[i]);
        }
        return result;
    }

    public int dfs(int[] nums, int n, int[] memory) {
        if (memory[n] != -1) {
            return memory[n];
        }
        memory[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[n] > nums[i]) {
                memory[n] = Math.max(dfs(nums, i, memory) + 1, memory[n]);
            }
        }
        return memory[n];
    }

    public static void main(String[] args) {
        L300lengthOfLIS_250715_1 l300lengthOfLIS2507151 = new L300lengthOfLIS_250715_1();
        l300lengthOfLIS2507151.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

    }
}

public class my2_10_16 {
    public static int bin_search(int[] tan, int tmpMaxLen, int value) {
        int l = 1;
        int r = tmpMaxLen;
        while (l < r) {
            int mid = (r + l + 1) / 2;
            if (tan[mid] >= value) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }


    public static int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] tan = new int[len + 1];
        Arrays.fill(tan, 0);
        int tmpMaxLen = 1;
        tan[1] = nums[0];

//        i从1开始了啊
        for (int i = 1; i < len; i++) {

            if (nums[i] > tan[tmpMaxLen]) {

                tan[++tmpMaxLen] = nums[i];
            } else {
                int position = bin_search(tan, tmpMaxLen, nums[i]);
//                注意这个处理啊,这个&&也特别重要，position为1可能更新 tan1 ，也可能更新tan2,注意是tan1 而不是tan0啊，最短1啊，注意这里是大于等于才行啊
                if (position == 1 && tan[1] >= nums[i]) {
                    tan[position] = nums[i];
                } else {
                    tan[position + 1] = nums[i];
                }


            }
            System.out.println(i + " " + tan[tmpMaxLen]);


        }

        return tmpMaxLen;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
