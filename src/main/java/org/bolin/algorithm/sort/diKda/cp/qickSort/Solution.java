package org.bolin.algorithm.sort.diKda.cp.qickSort;

import java.util.Random;

class Solution {
    private Random random = new Random();
    private int quicksort(int[] a, int l, int r, int k) {
        int idx = random.nextInt(r - l + 1) + l;
        int tmp = a[idx];
        a[idx] = a[l];
        a[l] = tmp;
        int pivot = a[l], i = l, j = r;
        while (i < j) {
            while (i < j && a[j] >= pivot) -- j;
            while (i < j && a[i] <= pivot) ++ i;
            if (i < j) { tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
        }
        a[l] = a[i];
        a[i] = pivot;
        return i == k ? a[i] : (i < k ? quicksort(a, i + 1, r, k) : quicksort(a, l, i, k));
    }
    public int findKthLargest(int[] nums, int k) {
        return quicksort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static void main(String[] args){
        System.out.println("sdfds");
        int [] nums=new int[]{99,99};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums,2));



    }
}